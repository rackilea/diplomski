childHolder.section_btn.setOnClickListener(new OnClickListener()    
    {    
        @Override    
        public void onClick(View v)    
        {    
            LinearLayout ll = (LinearLayout) v.getParent();    // get the view containing the button
            TextView tv1 = (TextView) ll.findViewById(R.id.ListItem1);  // get the reference to the first widget
            TextView tv2 = (TextView) ll.findViewById(R.id.ListItem2);  // get the reference to the second widget
            String text1 = tv1.getText.toString();  // Get the contents of the first widget to a string
            String text2 = tv2.getText.toString();  // Get the contents of the second widget to a string
        }    
    });