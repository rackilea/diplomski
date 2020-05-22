private static void callMethod() throws BundleException {

    final IStorageServiceClient client = StorageServiceConsumerProvider.getStorageServiceClient(envType);

    final StorageObjectIdentifier objIdentifierDir = new StorageObjectIdentifier(name, version, null);

    final List<Map<String, String>> dirs = new ArrayList<Map<String, String>>();
    client.listDirectory(objIdentifierDir, dirs);

    final String filename = name + Constants.DASH + version + Constants.DOTJAR;

    final StorageObjectIdentifier objIdentifier = new StorageObjectIdentifier(name, version, filename);

    // now I get the byte array of the jar file here.
    final byte[] b = client.retrieveObject(objIdentifier);

    // now the jar file is there in that location, and now I am using the full path of the jar file to intall it.
    BundleContext context = framework.getBundleContext();
    List<Bundle> installedBundles = new LinkedList<Bundle>();

    installedBundles.add(context.installBundle(fileName, new ByteArrayInputStream(b)));

    for (Bundle bundle : installedBundles) {
        bundle.start();
    }
}