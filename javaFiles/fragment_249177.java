package com.stackoverflow.q3475076;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@RequestScoped
public class Bean {

    private String fragment;

    public void processFragment(AjaxBehaviorEvent event) {
        // Do your thing here. This example is just printing to stdout.
        System.out.println("Process fragment: " + fragment);
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

}