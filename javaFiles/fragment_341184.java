public void addListenerOnButton(View v) {
     Button add = (Button) v.findViewById(R.id.button1);
     add.setOnClickListener(new OnClickListener()
     {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent(getActivity(), Review.class);
                startActivity(intent);
                break;
            }
        }
    });
 }