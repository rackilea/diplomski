// New and improved (shorter) version. :-)
private static <T> T lookupProviderByName(final ServiceRegistry registry, final String providerClassName) {
    try {
        return (T) registry.getServiceProviderByClass(Class.forName(providerClassName));
    }
    catch (ClassNotFoundException ignore) {
        return null;
    }
}