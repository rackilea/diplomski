package de.scrum_master.aspect;

import de.scrum_master.app.Application;
import de.scrum_master.app.Entity;

public aspect EntityAddInterceptor {
    pointcut addEntity(Object addedObject) :
        within(Application) && call(* *.add(*)) && args(addedObject);

    before(Object addedObject) : addEntity(addedObject) {
        if (addedObject.getClass().isAnnotationPresent(Entity.class))
            System.out.println(thisJoinPointStaticPart + " -> " + addedObject);
    }
}