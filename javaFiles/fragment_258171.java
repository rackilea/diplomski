package de.scrum_master.app;

import de.scrum_master.app.UpdateRequester;
import de.scrum_master.app.Test.UpdateRequesterStarter;

public aspect TestUpdate {
    pointcut testUpdateFlow() :
        cflow(execution(public void UpdateRequesterStarter.run(..)));

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