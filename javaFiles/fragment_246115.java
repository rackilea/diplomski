public class MainActivity extends Activity

{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View title = getWindow().findViewById(android.R.id.title);

        if (title != null) { 
             ViewParent titleBar = title.getParent(); 
           if (titleBar != null && (titleBar instanceof View)) { 
                View parentView = (View)titleBar; 
                parentView.setBackgroundColor(Color.RED); 
              } 
         } 

        // Your Code here...