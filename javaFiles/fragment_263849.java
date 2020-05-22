public class My_Main extends Activity {
 private new_viewer pv = null;
 @Override
 public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my__main);
    pv = new new_viewer(this);
 }


 public void test()
 {
 //Access pv here..
 }
}