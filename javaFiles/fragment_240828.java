public void setDelOnClick(View v) {
    EditText viewCal = (EditText) findViewById(R.id.viewCal);
    int lengthView = viewCal.getText().length();
    String viewCalString = viewCal.getText().toString();
    if(lengthView > 0 && lengthView <=1)
        viewCal.getText().delete(lengthView - 1, lengthView);
    else
    { 
       if(lengthView > 1)
       {
          String last2Char = viewCalString.substring(lengthView -2, lengthView);

          switch(last2Char) {
           case "in":
            viewCal.getText().delete(lengthView - 3, lengthView);
            break;

           case "os":
            viewCal.getText().delete(lengthView - 3, lengthView);
            break;

           case "ln":
            viewCal.getText().delete(lengthView - 2, lengthView);
            break;

           default:
            viewCal.getText().delete(lengthView - 1, lengthView);
            break;
       }  }
    }
}