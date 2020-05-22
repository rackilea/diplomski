Bundle bundle = .... your plugin bundle

URL url = FileLocator.find(bundle, new Path("/resources/driver"), null);

url = FileLocator.toFileURL(url);

String cmd = url.getFile();

Runtime.getRuntime().exec(cmd);