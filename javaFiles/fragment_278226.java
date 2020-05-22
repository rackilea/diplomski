HorizontalFieldManager manager = new HorizontalFieldManager();
BitmapField bitmap = new BitmapField(PNGEncodedImage.getEncodedImageResource("icon.png").getBitmap());
LabelField label = new LabelField(text);

manager.add(bitmap);
manager.add(label);

setTitle(manager);