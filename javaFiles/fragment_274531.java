package org.example;



/**
 * Created by prahaladd on 08/07/15.
 */
public class Person implements Model<StringIdentifier>
{

    private final String name;
    private final String id;

    public Person(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
    @Override
    public StringIdentifier getIdentifier()
    {
        return new StringIdentifier(id);
    }

    public String getName()
    {
        return  name;
    }
}