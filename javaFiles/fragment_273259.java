URL url = FileLocator.find(bundle, new Path("assets/Temp.txt"), null);

URL fileUrl = FileLocator.toFileURL(url);

File file = new File(fileUrl.getPath());

... read the file in the usual way