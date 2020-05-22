package de.scrum_master.aspect;

import my.thirdparty.application.Foo;
import my.thirdparty.application.Bar;

public aspect MethodInterceptor {
    pointcut directCalls(Bar barObject) :
        call(* Foo.foo(..)) && cflow(execution(* Bar.bar(..))) && this(barObject) &&
        if("bar".equals(thisEnclosingJoinPointStaticPart.getSignature().getName()));

    Object around(Foo fooObject, Bar barObject) : directCalls(barObject) && target(fooObject) {
        System.out.println(thisJoinPointStaticPart + " -> caller = " + thisEnclosingJoinPointStaticPart);
        new Exception("printing stack trace").printStackTrace(System.out);
        System.out.println();
        return proceed(fooObject, barObject);
    }
}