package com.component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.daimler.datalayer.apistreamintegration.exception.BadRequest;

@Component
public class UrlFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlFilter.class);

    @Override
    public void init(FilterConfig filterChain) throws ServletException {

    }


    /* 
     * filter call to check if any double forward slash(//) present in URI before invoking Controller class 
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        LOGGER.info("Filtering the url");
        if (!(request instanceof HttpServletRequest)) {
            return;
        }
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        boolean isInvalidUrl = requestURI.contains("//");
        if (isInvalidUrl) {
            throw new BadRequest("The request was rejected because the URL was not normalized.");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}