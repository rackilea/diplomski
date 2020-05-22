//get the linearlayout from xml
LinearLayout linearLayout = (LinearLayout)findViewById(R.id.my_layout);
//dynamically create your table layout 
TableLayout tablelayout = new TableLayout(this);
//add tablelayout to linearlayout
linearLayout.addView(tablelayout);