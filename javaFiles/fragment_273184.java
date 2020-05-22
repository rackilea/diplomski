LinearLayout ll = new LinearLayout(this);
 ll.setOrientation(LinearLayout.HORIZONTAL);
 ll.addView(playButton);
 ll.addView(buttonView);

 LinearLayout linearLayout = (LinearLayout) findViewById(R.id.button_row);
 linearLayout.addView(projectButton);
 linearLayout.addView(ll);