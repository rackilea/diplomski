public View getView(int position, View convertView, ViewGroup parent) {
   if (convertView == null) {
        convertView = LayoutInflater.from(context).inflate(R.layout.image_tap_view, parent, false);
   }
   ImageView imageView = (ImageView) convertView.findViewById(R.id.image);

   try {
       String url = "http://www.example.com/lionshop/" + images.get(position);
       DownloadPicasso(url, imageView);
   } catch (Exception e){
       Log.d("LoadImage", e.getLocalizedMessage());
   }

   imageView.setAdjustViewBounds(true);
   imageView.setScaleType(ImageView.ScaleType.FIT_XY);
   return convertView;
}