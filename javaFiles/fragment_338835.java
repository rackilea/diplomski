@Override
public ViewHolder onCreateViewHolder(ViewGroup parent) {
    final ImageCardView cardView = new ImageCardView(mContext);    

    cardView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, final boolean isFocused) {
            final View infoField = view.findViewById(R.id.info_field);
            final TextView contentField = (TextView)view.findViewById(R.id.content_text);
            final TextView titleField = (TextView)view.findViewById(R.id.title_text);
            final Drawable mainImage = ((ImageView)view.findViewById(R.id.main_image)).getDrawable();

            if (isFocused) {
                ((TextView)cardView.findViewById(R.id.title_text)).setMaxLines(3);
                FrameLayout.LayoutParams infoLayout = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                infoField.setLayoutParams(infoLayout);
                RelativeLayout.LayoutParams contentLayout = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                contentLayout.addRule(RelativeLayout.BELOW, R.id.title_text);
                contentField.setLayoutParams(contentLayout);
            }
            else {
                ((TextView)cardView.findViewById(R.id.title_text)).setMaxLines(1);
            }
        }
    });

    cardView.setFocusable(true);
    cardView.setFocusableInTouchMode(true);
    cardView.setBackgroundColor(mContext.getResources().getColor(R.color.fastlane_background));
    return new ViewHolder(cardView);
}