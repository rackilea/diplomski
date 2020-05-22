@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View vi = convertView;
    if (convertView == null)
        vi = inflater.inflate(R.layout.list_row, null);

    ImageView imageView = (ImageView) vi.findViewById(R.id.imageView);
    final ProgressBar progressBar = (ProgressBar) vi.findViewById(R.id.progressBar);
    TextView textView = (TextView) vi.findViewById(R.id.textView);

    textView.setText("" + position);

    progressBar.setVisibility(View.VISIBLE);

    Picasso.with(activity.getApplicationContext()).load(imagePath).resize(100, 100).centerCrop()
            .into(imageView, new Callback() {
                @Override
                public void onSuccess() {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError() {
                    //error
                }
            });

    return vi;
}