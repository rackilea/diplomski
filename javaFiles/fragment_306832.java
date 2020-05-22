package de.scrum_master.aspect;

import com.sun.security.auth.module.NTSystem;
import de.scrum_master.app.UserAuthentication;
import java.lang.reflect.Method;

public aspect TweakAuthenticationAspect {
    public static boolean hackingMode = false;

    pointcut reflectiveCall_NTSystem_getName(NTSystem ntSystem, Method method) :
        call(public Object Method.invoke(Object, Object...)) &&
        args(ntSystem, *) &&
        target(method) &&
        if(method.getName().equals("getName"));

    pointcut cflow_isCurrentUser(String userID) :
        cflow(
            execution(* UserAuthentication.isCurrentUser(String)) &&
            args(userID)
        );

    Object around(NTSystem ntSystem, Method method, String userID) :
        reflectiveCall_NTSystem_getName(ntSystem, method) &&
        cflow_isCurrentUser(userID) &&
        if(hackingMode)
    {
        System.out.println("Join point: " + thisJoinPoint);
        System.out.println("Given user ID: " + userID);
        System.out.println("Reflectively called method: " + method);
        return userID;
    }
}