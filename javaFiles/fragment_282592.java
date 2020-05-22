public ViewHolder(View view, Context context) {
    super(view);
    mView = view;
    mImageView = (ImageView) view.findViewById(R.id.avatar);
    mTextView = (TextView) view.findViewById(android.R.id.text1);
    activity = context;
}