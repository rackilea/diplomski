package org.foo.logging.internal;

import java.io.IOException;
import java.io.InputStream;

import java.util.logging.LogManager;

/*
 * This class could be referenced on the command-line as follows
 *
 * -Djava.util.logging.config.class=org.foo.logging.internal.LoggingPropertiesConfigurer
 *
 * See java.logging/java.util.logging.LogManager#readConfiguration().
 */
public class LoggingPropertiesConfigurer
{
    private static final String RESOURCE = "/logging.properties";

    public LoggingPropertiesConfigurer() throws IOException
    {
        try (final InputStream is = getClass().getResourceAsStream(
                                                        RESOURCE)) {
            if (is == null)
                throw new IllegalStateException(
                        String.format("Unavailable resource: '%s'",
                                                        RESOURCE));

            /* Prefer new non-null values over old values. */
            LogManager.getLogManager().updateConfiguration(is,
                                                    property ->
                                ((oldValue, newValue) -> {
                return (oldValue == null && newValue == null)
                    ? null  /* Discard the property. */
                    : (newValue == null)
                        ? oldValue
                        : newValue;
            }));
        }
    }
}