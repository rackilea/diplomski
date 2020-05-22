btnTag.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CharSequence name = btnTag.getText();
            locationFilter(name);
        }
    });