package de.scrum_master.aspect;

public aspect NonJDKInterceptor {
    before() : execution(* *(..)) {
        System.out.println(thisJoinPoint);
    }
}