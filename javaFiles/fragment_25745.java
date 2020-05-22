package de.scrum_master.aspect;

import de.scrum_master.app.NoLogging;

public aspect MyAspect {
    before() : execution(* *(..)) && !@annotation(NoLogging) {
        System.out.println(thisJoinPoint);
    }
}