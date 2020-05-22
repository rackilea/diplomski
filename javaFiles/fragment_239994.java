Bitmap builtFirst = Bitmap.createBitmap(500 * splitFirst.length, 700, ARGB_8888);
    Canvas canvas = new Canvas(builtFirst);

    if (buildFirst.length > 1) {

        for (int i = 0; i < buildFirst.length; i++) {

            canvas.drawBitmap(buildFirst[i], 300 * i, 0, null);
            canvas.drawBitmap(builtFirst, new Matrix(), null);

        }
    }

imageViewFirstNumber.setImageBitmap(builtFirst);