package org.foo.logging;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import java.util.logging.Logger;

import org.foo.logging.internal.LoggingPropertiesConfigurer;

public class Dummy
{
    static {
        try {
            final String fileName = System.getProperty(
                            "java.util.logging.config.file");
            final String klassName = System.getProperty(
                            "java.util.logging.config.class");

            if (klassName == null && fileName == null)
                new LoggingPropertiesConfigurer();
        } catch (final IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    static Optional<Logger> getLogger()
    {
        /*
         * Note that for any org.foo.Bar.Baz.Quux member class
         * Class::getName returns an org.foo.Bar$Baz$Quux string,
         * therefore name accordingly these loggers, if any, in
         * the properties files, e.g.
         *      org.foo.Bar$Baz$Quux.level = WARNING
         */
        return Optional.ofNullable(Logger.getLogger(
                                        Dummy.class.getName()));
    }

    public static void main(String[] args)
    {
        /*
         * A weakly-reachable logger.
         *
         * See java.base/java.lang.ref.Reference#reachabilityFence(Object)
         */
        Dummy.getLogger().ifPresent(logger -> logger.warning(() ->
                                        Arrays.toString(args)));
    }
}