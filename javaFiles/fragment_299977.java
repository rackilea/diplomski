InputStream is =
            SystemProperties.class.getResourceAsStream(versionResourceName);
try  {
    size = is.available(); // InputStream "is" = null
    ...
} catch (Exception ignore) {
}