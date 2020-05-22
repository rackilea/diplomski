// Get the global registry
IIORegistry registry = IIORegistry.getDefaultInstance();

// Lookup the known TIFF providers
ImageReaderSpi jaiProvider = lookupProviderByName(registry, "com.sun.media.imageioimpl.plugins.tiff.TIFFImageReaderSpi");
ImageReaderSpi geoProvider = lookupProviderByName(registry, "it.geosolutions.imageioimpl.plugins.tiff.TIFFImageReaderSpi");

if (jaiProvider != null && geoProvider != null) {
    // If both are found, EITHER
    // order the it.geosolutions provider BEFORE the com.sun (JAI) provider
    registry.setOrdering(ImageReaderSpi.class, geoProvider, jaiProvider);

    // OR
    // un-register the JAI provider
    registry.deregisterServiceProvider(jaiProvider);
}