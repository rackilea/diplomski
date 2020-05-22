TypedArray imgs = getResources().obtainTypedArray(R.array.ar_ex_1);

// get resource ID by index
imgs.getResourceId(i, -1)

// or set you ImageView's resource to the id
mImgView1.setImageResource(imgs.getResourceId(i, -1));

// recycle the array
imgs.recycle();