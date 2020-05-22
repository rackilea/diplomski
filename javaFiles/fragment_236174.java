package com.test;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class TestMultipleLoginPagesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMultipleLoginPagesApplication.class, args);
    }
}

@Controller
class MvcController {
    @RequestMapping(path="form/formLogin", method=RequestMethod.GET)
    public String formLoginPage() {
        return "formLogin";
    }

    @RequestMapping(path="form/formHome", method=RequestMethod.GET)
    public String formHomePage() {
        return "formHome";
    }

    @RequestMapping(path="basic/basicHome", method=RequestMethod.GET)
    public String userHomePage() {
        return "basicHome";
    }

    @RequestMapping(path="basic/logout", method=RequestMethod.GET)
    public String userLogout(HttpSession session) {
        session.invalidate();
        return "basicLogout";
    }
}

@Configuration
@Order(1)
class FormSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/form/**")
            .authorizeRequests()
                .anyRequest().hasRole("FORM_USER")
            .and()
            .formLogin()
                .loginPage("/form/formLogin").permitAll()
                .loginProcessingUrl("/form/formLoginPost").permitAll()
                .defaultSuccessUrl("/form/formHome")
            .and()
                .logout().logoutUrl("/form/logout").logoutSuccessUrl("/form/formLogin")
            .and()
            .httpBasic().disable()
            .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("test")
            .roles("FORM_USER");
    }
}

@Configuration
@Order(2)
class BasicAuthSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/basic/**")
            .authorizeRequests()
            .anyRequest().hasRole("BASIC_USER")
            .antMatchers("/basic/logout").permitAll()
            .and()
                .httpBasic()
            .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("basic_user")
            .password("test")
            .roles("BASIC_USER");
    }
}

@Configuration
@Order(3)
class RootUrlSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
         * Put any security expectations from the root URL here, currently everything is permitted.
         * Since it's the last in the order /form/** and /basic/** have a priority over it.
         */
        http.antMatcher("/**")
            .authorizeRequests()
                .anyRequest().permitAll();
    }
}