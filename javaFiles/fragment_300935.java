public class YourView extends View {
    // class attributes   
    float touchX = 0;
    float touchY= 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //detect user touch        
        switch (event.getAction()) {
            // your logic using touchX and touchY now 
            // will keep values assigned here
        }
    }
}