package controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.Configuration;
import services.MailService;
import services.SimpleEmailService;
import domain.TblLogin;
import repo.TblLoginRepository;

import domain.TblPatient;
import repo.TblPatientRepository;

@RestController
public class MyService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration fmConfiguration; 

    @Autowired
    private PasswordEncoder passwordEncoder;    

    @Autowired
    private TblLoginRepository tblLoginRepository;

    @Autowired
    private TblPatientRepository tblPatientRepository;

    private HttpSession session;

    MyService(){        
    }


    //api/getHome
    @RequestMapping(value = {"/api/getHome"}, method = RequestMethod.GET)
    @CrossOrigin(origins = {"*"})
    public ResponseEntity<?> getHome(
            //HttpServletRequest request
            ) throws Exception {

                try {
                    //get logged in user from session
                    JSONObject user = SessionController.getLoggedUser(this.session);
                }
                catch (Exception e) {

                }

                //get Home Data
                MyApiHome myApiHome = new MyApiHome();
                JSONArray data = myApiHome.getHomeData();

                JSONObject response = ResponseWrapper(data, "success", "Fetching home data");
                return new ResponseEntity<>(response, HttpStatus.OK);
            //getHome service 
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @CrossOrigin(origins = {"*"})
    @ResponseBody
    public ResponseEntity<?> login(
            @RequestParam(value="email", required=false, defaultValue="email") String email,
            @RequestParam(value="password", required=false, defaultValue="password") String password, 
            HttpServletRequest request
            ) throws  Exception {

                //find matching account with email
                TblLogin checkAccount = tblLoginRepository.findByEmail(email);

                if (checkAccount != null) {

                    //do the passwords match
                    if(passwordEncoder.matches(password, checkAccount.getPassword())) {
                        // Encode new password and store it

                        JSONObject userDetails = getUserData(checkAccount);

                        //create ONE session
                        this.session = request.getSession(true);

                        //store user in session
                        SessionController.logUser(userDetails, this.session);                                           
                        JSONObject response = ResponseWrapper(null, "success", "User found login succesful");                           
                        return new ResponseEntity<>(response, HttpStatus.OK);

                    } else {
                        //create error response                         
                        JSONObject response = ResponseWrapper(null, "error", "User passwords do not match");
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    }
                } else{
                    //create error response
                    JSONObject response = ResponseWrapper(null, "error", "User has not been found");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }               
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @CrossOrigin(origins = {"*"})
    public ResponseEntity<?> logout(
            ) throws  Exception {

            //logout user
            SessionController.logOutUser(this.session);     

            //create success response
            JSONObject response = ResponseWrapper(null, "success", "User logged out");                          
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

}