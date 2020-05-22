String[] myData = searchResult.get(position);

 // Add The Text!!!
 TextView tv = (TextView)MyView.findViewById(R.id.no);
 tv.setText(" "+ position );

 TextView ap = (TextView)MyView.findViewById(R.id.apperture);
 ap.setText(" "+ myData[1] );

 TextView sp = (TextView)MyView.findViewById(R.id.speed);
 sp.setText(" "+ myData[2] );