@Override public <E extends Enum<E>> void postEvent(
    Context context, E code, Object additionalData) 
{
    Object tmp = code;
    if (tmp instanceof LogEvent.Type)
    {
        LogEvent.Type scode = (LogEvent.Type)tmp;
    ...