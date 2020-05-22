public class MainActivity extends Activity {
pontos p1=new pontos();
pontos p2=new pontos();


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.<yourXMLFile>);
    }
            @Override
            public boolean onTouchEvent(MotionEvent event) {

                TextView tv1 = (TextView) findViewById(R.id.textView2);

                   int eventaction= event.getAction();

                   switch (eventaction){
                   case MotionEvent.ACTION_DOWN:
                       p1.x=event.getX();
                       break;   

                   }

                   tv1.setText(""+p1.x);

                   return true;
            }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}