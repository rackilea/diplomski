@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    listeners(); // set up all the listeners for the buttons    
}

public void listeners()
{
    setContentView(R.layout.main); // return to home screen
    // sets up a listener for when the GCF main screen button is clicked.
    GCFButton.setOnClickListener(new View.OnClickListener() 
    {
        public void onClick(View v) 
        {
            setContentView(R.layout.gcf); // change to the gcf layout
            Button back = (Button)findViewById(R.id.btnBack); // set up the back button in the gcf layout
            back.setOnClickListener(new View.OnClickListener() // put a listener on back button
            {
                public void onClick(View v) 
                {
                    listeners(); // recursively call the listeners again to 'start over'
                }
            });

            Button GCFCalculate = (Button)findViewById(R.id.btnCalculate); // set up the gcf button in the gcf layout
            GCFCalculate.setOnClickListener (new View.OnClickListener() // put listener on gcf button in gcf layout
            {
                public void onClick(View v)
                {
                    // do stuff
            }
        });
    }
});