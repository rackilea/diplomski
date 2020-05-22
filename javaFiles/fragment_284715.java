ScrollView scroll = findViewById(R.id.scrollView1);
    scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
        @Override
        public void onScrollChange(View view, int i, int i1, int i2, int i3) {
            et.clearFocus();
        }
    });