public class MainActivity extends Activity {

RelativeLayout rl;
int x = 0,y=0;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    rl = (RelativeLayout) findViewById(R.id.rl);
    CustomView cv = new CustomView(this);
    rl.addView(cv);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

public class CustomView extends View {

    Bitmap bball; 
    Random randX, randY;
    double theta;
    Handler m_handler;
    Paint p ;

    int width;
    int height;

    Runnable m_handlerTask;  


    public CustomView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        p= new Paint();
        bball = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);  
        //randX = 1 + (int)(Math.random()*500); 
        //randY = 1 + (int)(Math.random()*500);
        randX = new Random();
        randY = new Random();
        theta = 45;
        m_handler = new Handler();   
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // TODO Auto-generated method stub
        super.onSizeChanged(w, h, oldw, oldh);
        width =w;
        height=h; 
    }

    public void move()
    {
        m_handlerTask = new Runnable()
           {
             @Override 
             public void run() {
                 //theta = theta + Math.toRadians(2);

                  if(x<300)
                   {
                       x= x+10;
                       invalidate();
                   }
          else if(x>300)
           {
               x=0;
               m_handler.removeCallbacks(m_handlerTask);

           }
          // canvas.drawBitmap(bball, x, y, p);
            m_handler.postDelayed(m_handlerTask, 3000); 

             }
           };
           m_handlerTask.run();  

    }

    public void onDraw(final Canvas canvas){
        super.onDraw(canvas);
       canvas.drawBitmap(bball, x, y, p);  
       if(x<300)
           {
           move();
           }
       else 
       {

           m_handler.removeCallbacks(m_handlerTask);

       }


    }


}
 }