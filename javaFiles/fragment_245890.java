package com.something;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {
    private long maxPeriod;

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession( false );
        if ( session != null ) {
            long activated = (long) session.getAttribute( "activation-time" );
            if ( System.currentTimeMillis() > ( activated + maxPeriod ) ) {
                 session.invalidate();
            }
        }
        chain.doFilter(req, res);
    }

    public void init(FilterConfig config) throws ServletException {
        //Get init parameter
        if ( config.getInitParameter("max-period") == null ) {
             throw new IllegalStateException( "max-period must be provided" );
        }
        maxPeriod = new Long( config.getInitParameter("max-period") );
    }

    public void destroy() {
        //add code to release any resource
    }
}