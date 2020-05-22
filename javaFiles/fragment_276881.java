package com.your.package.converters.simplexml;

import org.joda.time.DateTime;
import org.simpleframework.xml.transform.Transform;
import org.slf4j.LoggerFactory;

/**
 *
 * © 2014 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for such usage and its consequences.
 */
public class JodaTimeDateTimeTransform implements Transform<DateTime>
{
    //static final org.slf4j.Logger logger = LoggerFactory.getLogger( JodaTimeDateTimeTransform.class );

    @Override
    public DateTime read ( String input ) throws Exception
    {
        DateTime dateTime = null;
        try {
            dateTime = new DateTime( input );  // Keeping whatever offset is included. Not forcing to UTC.
        } catch ( Exception e ) {
            //logger.debug( "Joda-Time DateTime Transform failed. Exception: " + e );
        }
        return dateTime;
    }

    @Override
    public String write ( DateTime dateTime ) throws Exception
    {
        String output = dateTime.toString();  // Keeping whatever offset is included. Not forcing to UTC.
        return output;
    }

}