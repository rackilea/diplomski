package de.scrum_master.aspect;

import my.thirdparty.application.Foo;
import my.thirdparty.application.Bar;

public aspect MethodInterceptor {
    pointcut callsFromBar(Bar barObject) :
        call(* Foo.foo(..)) && cflow(execution(* Bar.bar(..))) && this(barObject);

    Object around(Foo fooObject, Bar barObject) : callsFromBar(barObject) && target(fooObject) {
        System.out.println(thisJoinPointStaticPart + " -> caller = " + thisEnclosingJoinPointStaticPart);
        new Exception("printing stack trace").printStackTrace(System.out);
        System.out.println();
        return proceed(fooObject, barObject);
    }
}