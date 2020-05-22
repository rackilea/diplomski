builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
           //get text to string
           String text = "Min : "+TMin+"Thr : "+Thr;
           textView_main.setText(text);  
        }
 });