Button button = (Button) rootView.findViewById(R.id.my_button);
button.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        doSomething();
    }
});