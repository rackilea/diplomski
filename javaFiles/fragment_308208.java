/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ms2.spectrum.security.jersery;

import com.ms2.spectrum.security.jersey.resources.HelloWorld;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 *
 * @author Roger
 */
public class JerseyApplication extends ResourceConfig {

    public JerseyApplication() {
        register(RequestContextFilter.class);
    }

}