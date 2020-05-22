private void addView() {
        View customView = getLayoutInflater.inflate(resId, null);
        final TextView textView = (TextView) customView.findViewById(R.id.textview);
        customView.findViewById(R.id.imageview).setOnClickListener(new OnClickLitener(View v) {
            textView.setText("value");
        });
        container.addView(customView);
    }