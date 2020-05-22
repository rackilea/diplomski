package de.scrum_master.aspect;

public aspect FileInterceptor {
    before() : within(de.scrum_master.app.Application) {
        System.out.println(thisJoinPoint);
    }
}