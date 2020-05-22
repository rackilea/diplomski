import com.springapp.Entity.User;
 import com.springapp.Service.RoleService.RoleService;
 import com.springapp.Service.UserService.UserService;
 import com.springapp.mvc.RegisterForm;
 import com.springapp.mvc.UserValidator;
 import org.apache.log4j.Logger;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.ui.ModelMap;
 import org.springframework.validation.BindingResult; 
 import org.springframework.web.bind.annotation.ModelAttribute;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.servlet.ModelAndView;

 import javax.servlet.http.HttpServletRequest;
 import javax.validation.Valid;

 @Controller
 public class RegisterController {
 //Log4j
 private static final Logger logger = Logger.getLogger(RegisterController.class);


 @Qualifier("userServiceImpl")
 @Autowired
 private UserService userService;  

 @Qualifier("roleServiceImpl")
 @Autowired
 private RoleService roleService;


 private void putNewUserForm(ModelAndView model) {
     RegisterForm newUser = new RegisterForm();
     model.addObject("newUser", newUser);
 }

 @RequestMapping(value = "/register", method = RequestMethod.GET)
 public String register(ModelMap model) {
    model.addAttribute("newUser", new RegisterForm());
     return "register";
 } 

 @RequestMapping(value = "/register.do", method = RequestMethod.POST)
 public String sayHello(RegisterForm newUser, Model model) {
     model.addAttribute("newUser", newUser);   

    if (createUser(newUser, model)) {
        return "register";
    }
    return "welcome";
}

private boolean createUser(RegisterForm newUser, Model modelAndView) {
    User user = newUser.getUser();
    user.setRole(roleService.findByName(newUser.getRole()));
    userService.insertUser(user);
    return false;
}