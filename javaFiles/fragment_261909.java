result.setOnClickListener(new View.OnClickListener()
 {
    @Override
    public void onClick(View v)
    {
         display.setText("Name: " + lname.getText().toString() + ", " + fname.getText().toString());
    }
  });