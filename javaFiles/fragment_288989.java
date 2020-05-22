DrawPageElement drawPageElement = slide.getOdfElement();
DrawFrameElement drawFrame = OdfElement.findFirstChildNode(DrawFrameElement.class, drawPageElement);
DrawImageElement image = drawFrame.newDrawImageElement();
OdfPackage mOdfPackage = odp.getPackage();
String imageRef = "/some/path/to/chart.png";

String packagePath = odp.getDocumentPath() + OdfPackage.OdfFile.IMAGE_DIRECTORY.getPath() + "/" + someMethodToCreateRandomString();

mOdfPackage.insert(new URI(imageRef), packagePath, OdfFileEntry.getMediaTypeString(imageRef));
packagePath = packagePath.replaceFirst(odp.getDocumentPath(), "");
URI uri = new URI(AnyURI.encodePath(packagePath).toString());
image.setXlinkHrefAttribute(AnyURI.decodePath(uri.toString()));
image.setXlinkActuateAttribute("onLoad");
image.setXlinkShowAttribute("embed");
image.setXlinkTypeAttribute("simple");