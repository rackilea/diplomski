public final File getH2() {
    final ProtectionDomain pd = Server.class.getProtectionDomain();
    assert pd != null;
    final CodeSource cs = pd.getCodeSource();
    assert cs != null;
    final URL location = cs.getLocation();
    assert location != null;
    try {
      return new File(location.toURI());
    } catch (final URISyntaxException wontHappen) {
      throw (InternalError)new InternalError().initCause(wontHappen);
    }
 }