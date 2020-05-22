@ServiceActivator(inputChannel = "channel4", outputChannel="next")
public App save(App app)
{
    appRepository.save(app);
    return app;
}