package com.rhv.um.filter;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.rhv.RegistrationApplication;

public class MyFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    public List<ConfigAttribute> getAttributes(Object object) {
        FilterInvocation fi = (FilterInvocation) object;
        HttpServletRequest request = fi.getRequest();
        HttpMethod httpMethod = HttpMethod.valueOf(fi.getRequest().getMethod());

        // Bypassing Security check for /js, /css and /images url
        if (new AntPathRequestMatcher("/js/**").matches(request)
                || new AntPathRequestMatcher("/css/**").matches(request)
                || new AntPathRequestMatcher("/images/**").matches(request)
                || new AntPathRequestMatcher("/login").matches(request)
                || new AntPathRequestMatcher("/").matches(request)) {
            return SecurityConfig.createList(new String[] { "Allow" });
        }

        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities();

        try {
            for (GrantedAuthority grantedAuthority : authorities) {
                if(grantedAuthority.toString().equalsIgnoreCase("Administrator")) {
                    return SecurityConfig.createList(new String[] { "Allow" });
                }

                for(String allowedUrl : RegistrationApplication.permissions.get(grantedAuthority.toString()).get(httpMethod)) {
                    if(new AntPathRequestMatcher(allowedUrl).matches(request)) {
                        return SecurityConfig.createList(new String[] { "Allow" });
                    }
                }
            }
        } catch (Exception e) {
            return SecurityConfig.createList(new String[] { "Deny" });
        }

        return SecurityConfig.createList(new String[] { "Deny" });
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}