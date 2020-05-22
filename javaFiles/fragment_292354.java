package com.yourpckg;

import javax.ejb.Stateless;

// Stateless EJB with LocalBean view (default when no interface is implementated)
@Stateless
public class Calculator {

    // Business method (public) that may be invoked by EJB clients
    public int add(int x, int y) {
        return x + y;
    }
}