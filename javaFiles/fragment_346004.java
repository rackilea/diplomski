public int getEventCode(final Event event)
{
    final Class<? extends Event> c = event.getClass();
    final int index = EVENT_CLASSES.indexOf(c);
    return index != -1 ? index + 1 : c.hashCode() + 10;
}