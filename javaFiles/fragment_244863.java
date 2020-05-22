private int row;

private final AsyncLayoutInflater.OnInflateFinishedListener inflateListener =
    new AsyncLayoutInflater.OnInflateFinishedListener() {
        @Override
        public void onInflateFinished(View view, int resid, ViewGroup parent) {
            TextView myTextView = (TextView) view.findViewById(android.R.id.text1);
            myTextView.setText(myData.get(row).getName());
            ImageView myIcon = (ImageView) view.findViewById(android.R.id.icon);
            picasso.load(myData.get(i).getIcon()).into(myIcon);

            parent.addView(view);
            row++;
        }
    };