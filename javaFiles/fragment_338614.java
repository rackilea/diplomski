// Your plugin's bundle - there are several ways to get this
Bundle bundle = FrameworkUtil.getBundle(getClass());

// Relative path in the plugin
String path = "/img/img.jpg";

URL url = FileLocator.find(bundle, new Path(path), null);

ImageDescriptor imageDesc = ImageDescriptor.createFromURL(url);

Image image = imageDesc.createImage();