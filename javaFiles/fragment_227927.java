button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent intent = new Intent(context, Subactivity.class);
            startActivity(intent);

        }

    });