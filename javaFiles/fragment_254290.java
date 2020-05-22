package de.scrum_master.aspect;

public aspect NonJDKInterceptor {
    pointcut allCalls() : call(* *(..));
    pointcut jdkCalls() :
        call(* java..*(..)) || call(* javax..*(..)) ||
        call(* org.ietf..*(..)) || call(* org.omg..*(..)) ||
        call(* org.w3c..*(..)) || call(* org.xml..*(..)) ||
        call(* sun..*(..)) || call(* com.sun..*(..));

    before() : allCalls() && !jdkCalls() && !within(NonJDKInterceptor) {
        System.out.println(thisJoinPoint);
    }
}