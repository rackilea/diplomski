back_to_front.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ii = new Intent(getApplicationContext(), Quiz_front.class);
            startActivity(ii);

        }
    });