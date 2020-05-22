package de.scrum_master.aspect;

import java.io.Serializable;

public aspect MethodsWithSerializableArgumentsAspect {
    before() : execution(* *(..)) {
        boolean nonSerializableArgumentFound = false;
        for (Object arg : thisJoinPoint.getArgs()) {
            if (!(arg == null || arg instanceof Serializable)) {
                nonSerializableArgumentFound = true;
                break;
            }
        }
        if (nonSerializableArgumentFound)
            return;
        System.out.println(thisJoinPoint);
    }
}