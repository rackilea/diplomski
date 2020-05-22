private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    if (appId != null) {
        appIdNamespace = AppIdNamespace.parseEncodedAppIdNamespace(appId);
        appId = null;
    } else {
        appIdNamespace = new AppIdNamespace(DatastoreApiHelper.getCurrentAppId(), "");
    }
    validateAppIdNamespace(parentKey, appIdNamespace);
}