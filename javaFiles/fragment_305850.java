// in Activity code, maybe on a button click or onSaveInstanceState
// get a reference to the view
View drawView = getMyDrawViewFromSomewhere();

// get signature as a bitmap
drawView.buildDrawingCache();
Bitmap signature = drawView.getDrawingCache();

// convert to byte[]
ByteArrayOutputStream stream = new ByteArrayOutputStream();
signature.compress(Bitmap.CompressFormat.PNG, 100, stream);
byte[] byteArray = stream.toByteArray();