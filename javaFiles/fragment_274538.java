package org.example;

import java.util.Map;

/**
 * Created by prahaladd on 08/07/15.
 */
public class ChangeSet<M extends  Model>
{
    //Refer to PECS - http://stackoverflow.com/questions/2723397/java-generics-what-is-pecs

    private Map<? super Identifier, M> changeMap;

    private Class identifierType;

    public void addChange(M element)
    {
        //prahaladd - update :  save the identifier type for a later check.
        if(identifierType != null)
        {
             identifierType = element.getIdentifier.getClass();
        } 
        changeMap.put(element.getIdentifier(),element);
    }

    public M getChangedElementForId(Identifier id)
    {
        //prahaladd updated - verify that the type of the passed in id
        //is the same as that of the changeset identifier type.
        if(!id.getClass().equals(identifierType))
        {
                 throw new IllegalArgumentException();
        }
        return changeMap.get(id);
    }
}