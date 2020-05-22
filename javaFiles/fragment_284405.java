public void onClick(View v) {

       EditText money;
       try
       {
            money = (EditText)findViewById(R.id.bill);

             // This check makes sure that the EditText is returning the correct object.
            if(money != null)
            {
              int bill = Integer.parseInt(money.getText().toString());
              money.setText("Event Processed");
            }
       }
       catch(NumberFormatException e)
       {
       // If we get in here that means the inserted value was not an Integer. So do               something.
       //ie:
        money.setText("Please enter a value amount" );
        }
    }//end onClick