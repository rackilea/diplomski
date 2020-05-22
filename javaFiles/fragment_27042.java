Result runMain(JUnitSystem system, String... args) {
    system.out().println("JUnit version " + Version.id());

    JUnitCommandLineParseResult jUnitCommandLineParseResult = JUnitCommandLineParseResult.parse(args);

    RunListener listener = new TextListener(system);
    addListener(listener);

    return run(jUnitCommandLineParseResult.createRequest(defaultComputer()));
}