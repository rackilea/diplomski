// Read image data
DataInputStream data = new DataInputStream(in);
int w = data.readInt();
int h = data.readInt();
byte[] imgBytes = new byte[w * h * 4]; // 4 byte ABGR
data.readFully(imgBytes);

// Convert 4 byte interleaved ABGR to int packed ARGB
int[] pixels = new int[w * h];
for (int i = 0; i < pixels.length; i++) {
    int byteIndex = i * 4;
    pixels[i] = 
            ((imgBytes[byteIndex    ] & 0xFF) << 24) 
          | ((imgBytes[byteIndex + 3] & 0xFF) << 16) 
          | ((imgBytes[byteIndex + 2] & 0xFF) <<  8) 
          |  (imgBytes[byteIndex + 1] & 0xFF);
} 

// Finally, create bitmap from packed int ARGB, using ARGB_8888
Bitmap bitmap = Bitmap.createBitmap(pixels, w, h, Bitmap.Config.ARGB_8888);