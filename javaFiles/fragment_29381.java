package de.scrum_master.aspect;

import java.io.Serializable;

public aspect MethodsWithSerializableArgumentsAspect {
    pointcut returnsSerializable() :
        execution((Serializable+ || byte || short || int || long || float || double || char || boolean || void) *(..));

    pointcut hasNonSerializableArguments() :
        execution(* *(.., !(Serializable+ || byte || short || int || long || float || double || char || boolean || void), ..));

    before() : returnsSerializable() && !hasNonSerializableArguments() {
        System.out.println(thisJoinPoint);
    }
}