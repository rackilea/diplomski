package de.homer.server.config.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.homer.server.config.user.LoginService;

@Component
@Scope("session")
@Qualifier("loginBean")
public class LoginBean implements Serializable {

    @Autowired
    LoginService loginService;

    public final String doLogin() {
    // try to use loginService here
    // if I set breakpoint here I can see that loginService is null
    }

}