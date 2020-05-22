public class StdOutFilter extends ch.qos.logback.core.filter.AbstractMatcherFilter
{

    @Override
    public FilterReply decide(Object event)
    {
        if (!isStarted())
        {
            return FilterReply.NEUTRAL;
        }

        LoggingEvent loggingEvent = (LoggingEvent) event;

        List<Level> eventsToKeep = Arrays.asList(Level.TRACE, Level.DEBUG, Level.INFO);
        if (eventsToKeep.contains(loggingEvent.getLevel()))
        {
            return FilterReply.NEUTRAL;
        }
        else
        {
            return FilterReply.DENY;
        }
    }

}