public View getView(int position, View convertView, ViewGroup parent) {
ImageView imageView;
if (convertView == null) {  // if it's not recycled, initialize some attributes
    imageView = new ImageView(mContext);
    imageView.setLayoutParams(new GridView.LayoutParams(266, 266));
    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    imageView.setPadding(10, 10, 10, 10);
} else {
    imageView = (ImageView) convertView;
}

imageView.setImageResource(mThumbIds[position]);
//add your listener here.
imageView.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        switch (position) {
            //put whatever your different positions are
            case 0:
                startActivity(whatever activity name);
                break;
            case 1:
                startActivity(next activity name);
                break;
            //etc...
        startActivity("whatever you need to start");
    }
}

return imageView;