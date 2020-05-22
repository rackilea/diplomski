public class MainActivity extends Activity{
    // This is the class member, I was talking about
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         mTextView = new TextView(this);
         mTextView.setText("Button");

         mTextView.setLayoutParams(new ViewGroup.LayoutParams(
             ViewGroup.LayoutParams.WRAP_CONTENT,
             ViewGroup.LayoutParams.WRAP_CONTENT));
    }


    public void someMethod(){
        // Here you can reach to that TextView by using its reference saved in mTextView
       mTextView.setText("Hi there!");
    }
}