@Override
public void onClick(View v) {
     displayer(); //Call method "displayer" when user presses button
     TextView Tv = (TextView) findViewById(R.id.TV);
     TextView Tv2 = (TextView) findViewById(R.id.Tv2);
     String date = sdf.format(calendar.getTime());
     Tv.setText("The current time is " + date);
     String str = date.charAt(0) + "" + date.charAt(1) + "" + date.charAt(3) + "" + date.charAt(4);
     Tv2.setText("So the password will be " + str);
}