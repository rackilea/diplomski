public QuarantiningRunner(Class<?> testFileClass) throws InitializationError
{
    delegateRunningToDiscoverer = new DelegateRunningToDiscoverer();
    quarantinedPatternDiscoverer = new QuarantinedPatternDiscoverer();
    Class<? extends Runner> delegateRunningTo = delegateRunningToDiscoverer.getDelegateRunningToOn(testFileClass);
    ...