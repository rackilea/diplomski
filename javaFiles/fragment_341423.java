final View v = mView.findViewById(R.id.your_view_id);
Bitmap b = Bitmap.createBitmap( v.getMeasuredWidth(),
                v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
Canvas c = new Canvas(b);
v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
v.draw(c);
return b;