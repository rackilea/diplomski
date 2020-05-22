Category currentCategory = (Category) spCategory.getSelectedItem();
String total = etTotal.getText().toString();
String description = etDescription.getText().toString();
ImageView theicon =(ImageView) spCategory.getSelectedItem();
Bitmap bitmap = BitmapFactory.decodeByteArray(currentCategory.getImgico(),0,currentCategory.getImgico().length);
ByteArrayOutputStream imgbyte = new ByteArrayOutputStream();
bitmap.compress(Bitmap.CompressFormat.PNG, 100, imgbyte);
byte[] expenseIcons = imgbyte.toByteArray();