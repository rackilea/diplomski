EditText editText = new EditText(AddStuff.this);
    ... 
    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                                  RelativeLayout.LayoutParams.MATCH_PARENT, 
                                       RelativeLayout.LayoutParams.WRAP_CONTENT);

// get last child id from RelativeLayout
 int idLastChild=relativeLayout.getChildAt(relativeLayout.getChildCount()-1);
 params.addRule(RelativeLayout.BELOW,idLastChild);
  // set id for EditText 
 editText.setId(idLastChild+1);
 // set layout params
 editText.setLayoutParams(params);
 relativeLayout.addView(editText, params);