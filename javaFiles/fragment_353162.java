@Override
public Object instantiateItem(@NonNull ViewGroup container, int position) {
  inflater = (LayoutInflater)activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  final View itemView = inflater.inflate(R.layout.viewpager_item, container,false);

  final ImageView image = (ImageView)itemView.findViewById(R.id.imageView);
  DisplayMetrics dis = new DisplayMetrics();
  activity.getWindowManager().getDefaultDisplay().getMetrics(dis);
  int height = dis.heightPixels;
  int width = dis.widthPixels;
  image.setMinimumHeight(height);
  image.setMinimumWidth(width);

  itemView.setOnClickListener(new OnClickListener(){
    public void onClick(View v){
        // here you can show the image in fullscreen
        // First method : use an hidden fullscreen Layout (like the first piece of code you've posted)
        // Second method : use an Activity
    }
  try {
    Picasso.with(activity.getApplicationContext())
            .load(images[position])
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(image);
  }
  catch (Exception ex){

  }

  container.addView(itemView);
  return itemView;
}