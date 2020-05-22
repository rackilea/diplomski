package org.peronalitymeet.controller;

import org.peronalitymeet.entity.User;
import org.peronalitymeet.entity.request.AddUserRequest;
import org.peronalitymeet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ModelAndView findAllUsers(ModelAndView mav){
        List<User> users = userRepository.findAll();
        mav.addObject("users", users);
        mav.setViewName("users");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public void addUser(@RequestBody AddUserRequest addUserRequest){
        User user = new User();
        user.setFirstname(addUserRequest.getFirstname());
        user.setSurname(addUserRequest.getSurname());
        userRepository.save(user);
    }

}