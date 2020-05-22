package org.foo.logging.internal;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Objects;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class StandardOutConsoleHandler extends StreamHandler
{
    public StandardOutConsoleHandler(Formatter formatter)
    {
        super(new FileOutputStream(FileDescriptor.out),
                Objects.requireNonNull(formatter, "formatter"));
    }

    public StandardOutConsoleHandler() { this(new SimpleFormatter()); }

    /* Taken from java.logging/java.util.logging.ConsoleHandler. */
    @Override
    public void publish(LogRecord record)
    {
        super.publish(record);
        flush();
    }

    /* Taken from java.logging/java.util.logging.ConsoleHandler. */
    @Override
    public void close() { flush(); }
}