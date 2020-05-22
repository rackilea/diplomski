protected void drawSomething(Canvas canvas) {
        //canvas.drawColor(Color.BLACK);
        canvas.drawColor(Color.RED); // here i changed black to red(add you expected color here)
        if (bmpIcon != null) {
            canvas.drawBitmap(bmpIcon,
                    getWidth() / 2, getHeight() / 2, null);
        }

    }