ByteArrayOutputStream out = new ByteArrayOutputStream();
ImageLoader loader = new ImageLoader();
loader.data = new ImageData[] { image.getImageData() };
loader.save(out, SWT.IMAGE_PNG);
String base64 = Base64.getEncoder().encodeToString(out.toByteArray());
System.out.println(base64);