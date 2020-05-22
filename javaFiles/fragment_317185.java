LayoutInflater layoutInflater = (LayoutInflater)yourActivity.this.
     .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

View layout = layoutInflater.inflate(R.layout.yourlayout,null);

reportAlertDialog.setView(layout);