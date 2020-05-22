static class ConverterImpl extends DozerConverter<Version, String> {

    ConverterImpl() {
        super(Version.class, String.class);
    }

    @Override public String convertTo(Version version, String versionOrig)
    {
        return version.getFullVersion();
    }

    @Override public Version convertFrom(String version, Version versionOrig)
    {
        return new Version(version);
    }
}