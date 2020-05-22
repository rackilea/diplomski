int HW = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (pt number as dp), this.getResources().getDisplayMetrics());

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                HW,//width
                HW,//height
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);