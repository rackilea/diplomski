public class MainActivity implements OnTouchListener { 
...
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        touchx = (float) 200.0;//event.getX(); ive tried to just put solid numbers
        touchy = (float) 200.0;//event.getY(); but even that doesnt seem to work

        return true;
    }
...
}