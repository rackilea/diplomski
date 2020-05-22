@Override
    public Object instantiateItem(ViewGroup container,final int position) {
       final View itemView = mLayoutInflater.inflate(R.layout.image_slider_item, container, false);

      final TouchImageView imageView = (TouchImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(mResources[position]);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                CapturePhotoUtils photoUtils = new CapturePhotoUtils();
                imageView.setDrawingCacheEnabled(true);
                Bitmap b = imageView.getDrawingCache();
                photoUtils.insertImage(Full_Screen_Slider.this.getContentResolver(),
                    b, "1image", "this is downloaded image sample");
                Toast.makeText(mContext, "longpress ", Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        container.addView(itemView);

        return itemView;
    }