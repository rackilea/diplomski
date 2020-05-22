for (Button b : buttons) {
    b.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
             someMethod(v.getTag());
        }
    });
}