// determine free ports for Marionette and WebDriver
final int marionettePort = PortProber.findFreePort();
final int webDriverPort = PortProber.findFreePort();
// override, as GeckoDriverService provides no direct way to set the Marionette port
GeckoDriverService.Builder builder = new GeckoDriverService.Builder() {
    @Override
    protected ImmutableList<String> createArgs() {
        Builder<String> argsBuilder = ImmutableList.builder();
        argsBuilder.addAll(super.createArgs());
        argsBuilder.add(String.format("--marionette-port=%d", marionettePort));
        return argsBuilder.build();
    }
};
builder.usingPort(webDriverPort);
builder.usingDriverExecutable(pathToDriver);
GeckoDriverService driverService = builder.build();
try {
    driverService.start();
} catch (IOException e) {
    throw new IllegalStateException("Could not start the GeckoDriverService", e);
}
try {
    // keep checking the WebDriver port via Socket until it's available;
    // as far as I could tell, there is nothing more "high level", e.g. REST API
    waitUntilReady(webDriverPort, TimeUnit.SECONDS.toMillis(30));
} catch (InterruptedException e) {
    // ignore
}
return new MarionetteDriver(driverService, capabilities);