public View getView(int position, View convertView, ViewGroup parent) {

    newView = convertView;
    final ViewHolder holder;

    if (null == convertView) {
        holder = new ViewHolder();
        newView = inflater.inflate(R.layout.selfie_list_view, null);
        holder.selfieView = (ImageView) newView.findViewById(R.id.selfie_bitmap);
        holder.selfieName = (TextView) newView.findViewById(R.id.selfie_name);
        newView.setTag(holder);

    } else {
        holder = (ViewHolder) newView.getTag();
    }

    SelfieRecord curr = list.get(position);
    String selfieName = curr.getBitmapName();
    final String selfiePath = curr.getBitmapPath();
    //Bitmap selfie = setPic(newView, selfiePath);

    ViewTreeObserver vto = holder.selfieView.getViewTreeObserver();
    vto.addOnPreDrawListener(new OnPreDrawListener() {

        @Override
        public boolean onPreDraw() {
            holder.selfieView.getViewTreeObserver().removeOnPreDrawListener(this);
            int width = holder.selfieView.getMeasuredWidth();
            int height = holder.selfieView.getMeasuredHeight();
            Log.i(TAG, "view_width = " + width + " view_height =" + height);

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(selfiePath, bmOptions);
            int photoW = bmOptions.outWidth;
            int photoH = bmOptions.outHeight;
            Log.i(TAG, "photo_width = " + photoW + " view_height =" + photoH);

            // Determine how much to scale down the image
            int scaleFactor = Math.min(photoW/width, photoH/height);

            // Decode the image file into a Bitmap sized to fill the View
            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;
            bmOptions.inPurgeable = true;
            Bitmap bitmap = BitmapFactory.decodeFile(selfiePath, bmOptions);

            holder.selfieView.setImageBitmap(bitmap);

            return true;
        }
    });

    holder.selfieName.setText(selfieName);

    return newView;
}