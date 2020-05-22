public class MainActivity {
    public static int contentViewCount = 0;


    public void onCreate() {   //or perhaps onStart()
          contentViewCount = 0;
    }

    public void onResume() {
        if(contentViewCount == 0) {
            //set first layout and increment the static counter
            setContentView(R.layout.layout1);
            contentViewCount++;
        } else {
            setContentView(R.layout.layout2);
        }
    }
 }