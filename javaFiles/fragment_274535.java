package org.example;

/**
 * Created by prahaladd on 08/07/15.
 */
public class StringIdentifier implements Identifier<String>
{

    private final String identifier;

    public StringIdentifier(String id)
    {
        identifier = id;
    }

    @Override
    public String getIdentifier()
    {
        return "someId";
    }
}