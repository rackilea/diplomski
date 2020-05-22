One way is use get the color where user touched and compare that with the touchable area here (gray) in your case. If the pixel color is gray means user is touching at right spot if white that means untouchable area 

You can get the pixel color like this-

imageView.setOnTouchListener(new OnTouchListener(){
        @Override
        public boolean onTouch(View v, MotionEvent event){
        int x = (int)event.getX();
        int y = (int)event.getY();
        int pixel = bitmap.getPixel(x,y);

        //then do what you want with the pixel data, e.g
        int redValue = Color.red(pixel);
        int blueValue = Color.blue(pixel);
        int greenValue = Color.green(pixel);        
        return false;
        }
   });


Hope this helps