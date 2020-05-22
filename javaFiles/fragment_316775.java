package de.scrum_master.aspect;

import my.thirdparty.application.Foo;
import my.thirdparty.application.Bar;

public aspect MethodInterceptor {
    pointcut allCalls() :
        call(* Foo.foo(..));

    Object around(Foo fooObject) : allCalls() && target(fooObject) {
        System.out.println(thisJoinPointStaticPart + " -> caller = " + thisEnclosingJoinPointStaticPart);
        //new Exception("printing stack trace").printStackTrace(System.out);
        //System.out.println();
        return proceed(fooObject);
    }
}