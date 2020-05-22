@Override
public View getView( int position, View convertView, ViewGroup parent ) {
  LinearLayout itemView;

  // Inflate layout XML, etc.
  // ...

  // Find subviews in layout
  ImageView innerView = (ImageView) itemView.findViewById( R.id.myInnerViewId );

  // ...

  // Set up onClickListener for inner view
  innerView.setOnClickListener( new OnClickListener() {
    @Override
    public void onClick( View v ) {
      // Handle inner view tap
      // ...
    }
  } );

  // ...
}