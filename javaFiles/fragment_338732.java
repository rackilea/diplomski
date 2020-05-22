@Override
    public void onBeginRawDrawing(boolean b, TouchPoint touchPoint) {
        Log.d(TAG, "onBeginRawDrawing");
        startPoint = touchPoint;
        Log.d(TAG,touchPoint.getX() +", " +touchPoint.getY());
        countRec = 0; 
        if (baseBitmap == null) {
            baseBitmap = Bitmap.createBitmap(iv_canvas.getWidth(),
                    iv_canvas.getHeight(), Bitmap.Config.ARGB_8888);
            canva = new Canvas(baseBitmap);
            canva.drawColor(Color.WHITE);
            iv_canvas.setImageBitmap(baseBitmap);

        }
    }