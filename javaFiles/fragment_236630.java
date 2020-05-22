if(condition()) {

        TV=(TextView)view.findViewById(R.id.textView); // each time you call this you reintializ
                                                   // the TextView then set new text to it
                                                   // you don't append the text
        TV.setText(Html.fromHtml("<b>TEXT 01 </b>"));

   }
    else {
        TV=(TextView)view.findViewById(R.id.textView); 

        TV.setText(Html.fromHtml("<b>TEXT 02</b>"));

    } 

    if(condition) {
        TV=(TextView)view.findViewById(R.id.textView); 

        TV.setText(Html.fromHtml("TEXT 03"));

    }
    else {
         TV=(TextView)view.findViewById(R.id.textView); 

        TV.setText(Html.fromHtml("TEXT 04"));

  }