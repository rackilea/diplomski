@Override
public View getView(final int position, View convertView, ViewGroup parent) {

    Holder holder=new Holder();

    if (convertView == null) {

     convertView = inflater.inflate(R.layout.product_row, null);
     holder.title=(TextView) convertView.findViewById(R.id.productName);
     holder.img=(NetworkImageView) convertView.findViewById(R.id.productPic);
     holder.rating=(RatingBar)convertView.findViewById(R.id.ratingBar2);

     convertView.setTag(holder);
   }
   else
   {
       holder = (ViewHolder) convertView.getTag();
   }
       holder.title.setText(result.get(position).getName());
       holder.rating.setRating(Float.valueOf(result.get(position).getRating().toString()));


    // If you are using NetworkImageView
     holder.img.setImageUrl(result.get(position).getImageURL(), VolleyController.getInstance().getImageLoader());

    return convertView;
}