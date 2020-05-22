package com.test.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;

@Component
public class MyAuthenticationEntryPoint  extends BasicAuthenticationEntryPoint{
     @Override
        public void commence
          (HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
          throws IOException, ServletException {

            if (authEx.getCause() instanceof TransactionException){
                 response.addHeader("Internal Server Error", "Basic realm='" + getRealmName() + "'");
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }else{
                response.addHeader("Authenticate-Faliure", "Basic realm='" + getRealmName() + "'");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            setRealmName("test");
            super.afterPropertiesSet();
        }
}