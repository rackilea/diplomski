package de.scrum_master.aspect;

import de.scrum_master.app.Application;
import de.scrum_master.app.Entity;

public aspect EntityAddInterceptor {
    pointcut addEntity(Object addedObject) :
        within(Application) && call(* *.add(*)) && args(addedObject) && @args(Entity);

    before(Object addedObject) : addEntity(addedObject) {
        System.out.println(thisJoinPointStaticPart + " -> " + addedObject);
    }

    pointcut addEntitySpecial(Object addedObject) :
        cflow(execution(* *.addToMyList(*))) && (call(* *.add(*)) && args(addedObject))  && @args(Entity);

    before(Object addedObject) : addEntitySpecial(addedObject) {
        System.out.println(thisJoinPointStaticPart + " -> " + addedObject + " [special]");
    }
}