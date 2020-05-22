DatabaseHandler db = new DatabaseHandler(this);
Car cars = db.getCurrentCar();
byte[] imageData = Base64.decode(cars.get_image(), 0);
Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length, new BitmapFactory.Options());
ImageView imageView = //find your image view;
imageView.setImageBitmap(bitmap);