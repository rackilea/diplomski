public class MyActivity extends BaseActivity {
    // Your activity code    
}

public class BaseActivity extends Activity {
    @Override   
    public boolean dispatchTouchEvent(MotionEvent event) { 
        // do something   

        return super.dispatchTouchEvent(event);      
    }
}