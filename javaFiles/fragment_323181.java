final Properties props = new Properties();
    try {
        String v = System.getProperty("java.util.logging.config.file");
        if (v == null) {
           v = System.getProperty("java.home") + "/lib/logging.properties";
        }
        final File f = new File(v).getCanonicalFile();
        final InputStream in = new FileInputStream(f);
        try {
            props.load(in);
        } finally {
            in.close();
        }
    } catch (final RuntimeException permissionsOrMalformed) {
    } catch (final Exception ioe) {
    }