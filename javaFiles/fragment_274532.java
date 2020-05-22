package org.example;

import java.util.Map;

/**
 * Created by prahaladd on 08/07/15.
 */
public class ChangeSet<T extends Identifier, M extends  Model<T>>
{
    //Refer to PECS - http://stackoverflow.com/questions/2723397/java-generics-what-is-pecs

    private Map<? super Identifier, M> changeMap;

    public void addChange(M element)
    {
        changeMap.put(element.getIdentifier(),element);
    }

    public M getChangedElementForId(T id)
    {
        return changeMap.get(id);
    }
}