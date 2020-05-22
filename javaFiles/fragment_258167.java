package de.scrum_master.app;

import de.scrum_master.app.UpdateRequester;
import java.lang.Runnable;

public aspect TestUpdate {
    pointcut testUpdateFlow() :
        cflow(
            this(Runnable) &&
            withincode(public void Test..*.run(..)) &&
            call(* UpdateRequester.*(..))
        );

    pointcut throwMessageCut(String url, String response) :
        this(UpdateRequester) &&
        args(url, response) &&
        execution(void throwMessage(String, String));

    before(String url, String response) :
        testUpdateFlow() &&
        throwMessageCut(url,  response)
    {
        System.out.println(thisJoinPoint);
        new Exception().printStackTrace(System.out);
    }
}