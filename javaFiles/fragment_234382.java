Drawable d = imageView.getDrawable();

    Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
    byte[] ba;
    do {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();

        Log.e("BEFORE REDUCING",
                bitmap.getHeight() + " " + bitmap.getWidth() + " "
                        + bitmap.getRowBytes() * bitmap.getHeight());

        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bao);

        ba = bao.toByteArray();
        if ((ba.length / 1024) >= 650) {
            bitmap = Bitmap.createScaledBitmap(bitmap,
                    (int) (bitmap.getWidth() * 0.95),
                    (int) (bitmap.getHeight() * 0.95), true);

        }

        Log.e("BYTE LENGTH", "" + ba.length / 1024);

    } while ((ba.length / 1024) >= 650);

    String ba1 = Base64.encodeToString(ba, Base64.DEFAULT);