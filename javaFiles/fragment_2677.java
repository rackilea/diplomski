package com.test;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import java.util.LinkedList;
import java.util.List;

public class ListAppender extends AppenderBase<ILoggingEvent> {

    private static List<ILoggingEvent> eventList = new LinkedList<>();

    @Override
    protected void append(ILoggingEvent event) {
        eventList.add(event);
    }

    public List<ILoggingEvent> getEventList() {
        return eventList;
    }
}