public void setUpResize() {
    dragHandle.setOnTouchListener(new View.OnTouchListener() {

        float centerX, centerY, startR, startScale, startX, startY, startRotation, startA ;

        public boolean onTouch(View v, MotionEvent e) {

            if (e.getAction() == MotionEvent.ACTION_DOWN) {

                centerX = (imageView.getLeft() + imageView.getRight()) / 2f;
                centerY = (imageView.getTop() + imageView.getBottom()) / 2f;

                startX = e.getRawX() - dragHandle.getX() + centerX;
                startY = e.getRawY() - dragHandle.getY() + centerY; 

                startR = (float) Math.hypot(e.getRawX() - startX, e.getRawY() - startY);
                startA = (float) Math.toDegrees(Math.atan2(e.getRawY() - startY, e.getRawX() - startX));

                startScale = imageView.getScaleX();
                startRotation = imageView.getRotation();

            } else if (e.getAction() == MotionEvent.ACTION_MOVE) {

                float newR = (float) Math.hypot(e.getRawX() - startX, e.getRawY() - startY);
                float newA = (float) Math.toDegrees(Math.atan2(e.getRawY() - startY, e.getRawX() - startX));
                float newScale = newR / startR * startScale;
                float newRotation = newA - startA + startRotation;

                imageView.setScaleX(newScale);
                imageView.setScaleY(newScale);
                imageView.setRotation(newRotation);


                // ----- this part takes some effort to understand... ------
                dragHandle.setX((float) (centerX + Math.hypot(imageView.getWidth(), imageView.getHeight())/2f * newScale 
                        * Math.cos(Math.toRadians(newRotation) + Math.atan2(imageView.getHeight(), imageView.getWidth()))));

                dragHandle.setY((float) (centerY + Math.hypot(imageView.getWidth(), imageView.getHeight())/2f * newScale 
                        * Math.sin(Math.toRadians(newRotation) + Math.atan2(imageView.getHeight(), imageView.getWidth()))));
                //-----------------------------------------------------------

                dragHandle.setPivotX(0);
                dragHandle.setPivotY(0);
                dragHandle.setRotation(newRotation);


            } else if (e.getAction() == MotionEvent.ACTION_UP) {

            }
            return true;
        }
    });
}