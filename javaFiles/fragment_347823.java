package com.example.sunny.myfirstapp;

    public class MainActivity extends Activity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.greetings_view);

        String message= "welcome to my app";
        textView.setText(message);
    }
    }