public class Main extends Activity{

     @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            main_lL = (LinearLayout) findViewById(R.id.mainLinearLayout);

            XyloTouch xyloTouch = new XyloTouch();
            main_lL.setOnTouchListener(xyloTouch);
            ........
        }

    .....

    private class XyloTouch implements OnTouchListener{
    // exact code inside of Xylo class goes here. It can access the instance variables of Main as 
    // its an inner class and Main is a parent class.
    }

}