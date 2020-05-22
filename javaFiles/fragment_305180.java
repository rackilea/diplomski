@GetMapping("/test-mapping")
@ResponseStatus(HttpStatus.OK)
public void test() {
    SettingsDto settingsDto = new SettingsDto();
    ClassLoader previous = Thread.currentThread().getContextClassLoader();
    try {
        Thread.currentThread().setContextClassLoader(TestController.class.getClassLoader());
        SettingsModel model = mapper.map(settingsDto, SettingsModel.class);
    }
    finally {
        Thread.currentThread().setContextClassLoader(previous);
    }
}