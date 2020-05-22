googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
        @Override
        public View getInfoWindow(final Marker marker) {
            v[0] = getActivity().getLayoutInflater().inflate(R.layout.map_info_design, null);
            if (marker != null) {

                final ImageView logo=(ImageView)v[0].findViewById(R.id.logo);




                t1=new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        logo.setImageBitmap(bitmap);

                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                };
                Picasso.with(getActivity())
                        .load(b1.get(Integer.parseInt(marker.getSnippet()))).error(R.drawable.logo_icon)
                        .into(logo,new MarkerCallback(marker));

            }
            return (v[0]);
        }

        @Override
        public View getInfoContents(Marker marker) {


            return null;
        }
    });