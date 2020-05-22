package com.mycompany.aspect;

import com.mycompany.data.Secure;

public aspect SecureAspect {
    declare parents :
        !is(InterfaceType) && !is(EnumType) && com.mycompany.data.*
        implements Secure;

    public void Secure.doSomething() {
        System.out.println("I am a secure " + this.getClass().getSimpleName());
    }
}