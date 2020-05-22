TextView content = new TextView(this);
         content.setText("on another font");
         content.setTypeface(Typeface.SANS_SERIF);

//Use the first example, if your using a xml generated view

     AlertDialog.Builder myalert = new AlertDialog.Builder(this);
         myalert.setTitle("Your title");
         myalert.setView(content);
         myalert.setNeutralButton("Close dialog", null);
         myalert.setCancelable(true);
         myalert.show();