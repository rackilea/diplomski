Bitmap b1 = BitmapFactory.decodeFile("mybitmap.png");
ConcurrentHashMap<Bitmap, byte[]> pixels = new ConcurrentHashMap<Bitmap, byte[]>();
pixels.add(b1);
[...]
Bitmap b2 = BitmapFactory.decodeFile("mybitmap.png");
byte[] barray1 = pixels.get(b1);
byte[] barray2 = pixels.get(b2);