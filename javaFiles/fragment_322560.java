Button yourButton= (Button) findViewById(R.id.yourbuttonId); // your created button

     //what happens when touching the specific Button

    yourButton.setOnClickListener(new view.OnClickListener() { 


    @Override

    public void onClick(View v) {

    Dialog obj = new Dialog (this);   // Define New Dialog Named obj

    obj.setTitle("your dialog title)");  //Naming The Dialog title

    TextView tv = new TextView (this); // Creating TextView object to use it inside the Dialog 

    tv.setText("your Text to be shown in the Dialog"); // Setting the TextView Text 

    obj.setContentView(tv); // setting the TextView Content inside your Dialog

    obj.show(); // Method to show the dialog 

        // TODO Auto-generated method stub

    }
});