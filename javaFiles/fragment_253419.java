public enum Command
{
    START(StartCommand.class),
    END(EndCommand.class);

    private Class<? extends CommandInterface> mappedClass;
    private Command(Class<? extends CommandInterface> c) { mappedClass = c; }
    public CommandInterface getInstance()
    {
        return mappedClass.newInstance();
    }
}