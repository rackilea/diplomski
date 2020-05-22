private void writeObject(ObjectOutputStream out) throws IOException {
    if (appIdNamespace != null) {
      appId = appIdNamespace.toEncodedString();
    }
    out.defaultWriteObject();
}