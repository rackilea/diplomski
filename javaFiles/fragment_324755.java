public class MessageBuilder
{
    private final String fmt;
    private final Object[] args;

    public MessageBuilder(final String fmt, final int nrArgs)
    {
        this.fmt = fmt;
        args = new Object[nrArgs];
    }

    public MessageBuilder addArgument(final Object arg, final int index)
    {
        if (index < 0 || index >= args.length)
            throw new IllegalArgumentException("illegal index " + index);
        args[index] = arg;
        return this;
    }

    public String build()
    {
        return MessageFormat.format(fmt, args);
    }
}