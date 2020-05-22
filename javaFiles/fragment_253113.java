Bundle bundle = Platform.getBundle("your plugin id");

URL pluginURL = FileLocator.find(bundle, new Path("TestFile.eap"), null);

URL fileURL = FileLocator.toFileURL(pluginURL);

File file = new File(fileURL.getPath());