package com.example.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

    private static int sessionCount;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Creating session with id: " + se.getSession().getId());
        sessionCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Destroying session id: " + se.getSession().getId());
        sessionCount--;
    }

    public int getSessionCount() {
        return sessionCount;
    }
}