package com.your.package.converters.simplexml;

import org.simpleframework.xml.transform.Transform;
import org.simpleframework.xml.transform.Matcher;

/**
 *
 * © 2014 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for such usage and its consequences.
 */
public class JodaTimeDateTimeMatcher implements Matcher
{
    @Override
    public Transform match ( Class classType ) throws Exception
    {
        // Is DateTime a superclass (or same class) the classType?
        if ( org.joda.time.DateTime.class.isAssignableFrom( classType ) ) {
            return new JodaTimeDateTimeTransform();
        }
        return null;
    }
}