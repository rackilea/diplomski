SettingService settings = PlatformFactory.getPlatform().getSettingService();

settings.store("Info.Age", 10);
...
if (settings.retrieve("Info.Age") != null) {
    int age = Integer.parseInt(settings.retrieve("Info.Age"));
}