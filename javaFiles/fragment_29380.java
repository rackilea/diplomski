package de.scrum_master.aspect;

import java.io.Serializable;

public aspect MethodsWithSerializableArgumentsAspect {
    Object around() : execution(* *(..)) {
        boolean nonSerializableArgumentFound = false;
        for (Object arg : thisJoinPoint.getArgs()) {
            if (!(arg instanceof Serializable)) {
                nonSerializableArgumentFound = true;
                break;
            }
        }
        Object result = proceed();
        if ((result == null || result instanceof Serializable) && !nonSerializableArgumentFound)
            System.out.println(thisJoinPoint);
        return result;
    }
}