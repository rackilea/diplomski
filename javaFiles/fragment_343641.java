button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {

          Intent i = new Intent(CurrentActivity.this, ActivityTwo.class);
         startActivity(i); 

        }

    });