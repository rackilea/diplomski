paint.setStyle(Paint.Style.FILL);
paint.setColor(Color.parseColor("#BAB399")); // set fill color
canvas.drawCircle(sbmp.getWidth() / 2+0.7f, sbmp.getHeight() / 2+0.7f,
    sbmp.getWidth() / 2+0.1f, paint);

paint.setStyle(Paint.Style.STROKE);
paint.setStrokeWidth(10); // set stroke width
paint.setColor(Color.parseColor("#ffffff")); // set stroke color
canvas.drawCircle(sbmp.getWidth() / 2+0.7f, sbmp.getHeight() / 2+0.7f,
    sbmp.getWidth() / 2+0.1f, paint);