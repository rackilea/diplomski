@ServiceActivator(inputChannel = "channel4", outputChannel="next")
public SomeResult save(App app)
{
    appRepository.save(app);
    return new SomeResult(...);
}