// Get the textViews, to assign a listener to them
TextView textView1 = (TextView) v.findViewById(R.id.textView1);
TextView textView2 = (Textview) v.findViewById(R.id.textView2);
..... // Etc and so on

// Create this listener anywhere, including via making the adapter/class
    // implement the listener and passing it in instead
View.OnClickListener listener = new View.OnClickListener(
    @Override
    public void onClick(View v) {
        // Get the view as a TextView, as this will only be used
            // with TextViews, so the only view to be passed
            // will be Textviews
        TextView textView = (TextView) v;

        // Do whatever with that text, or however you want to use the view
        String text = textView.getText().toString();
        someFunction(text);
    }
);

textView1.setOnClickListener(listener);
textView2.setOnClickListener(listener);
..... // Etc and so on