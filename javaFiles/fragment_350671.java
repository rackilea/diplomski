rAnimAntiClockWise = new RotateAnimation(0.0f, 45.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rAnimAntiClockWise.setFillAfter(true);
        rAnimAntiClockWise.setInterpolator(new LinearInterpolator());       
            bitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.rotate);     
        rAnimAntiClockWise.setDuration(100);
        img_rotate.startAnimation(rAnimAntiClockWise);