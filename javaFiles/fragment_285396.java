String test = String.valueOf(mylist.get(position));
        String imgpath = getString(R.string.imgpath);
        String finalimgpath = imgpath + test;

Glide.with(context)
        .load(finalimgpath)               
        .into(imageView);
view.addView(imageLayout,position);
return imageLayout;