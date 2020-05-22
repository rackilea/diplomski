int bored = board.getId(); //board is the RelativeLayout
ImageView border = new ImageView(this);
border.setImageResource(R.drawable.border_tiki1);
RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
params.addRule(RelativeLayout.ALIGN_LEFT, bored);
params.addRule(RelativeLayout.ABOVE, bored);
this.addView(border,params);