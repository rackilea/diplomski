private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch(v.getId()){
                case R.id.button1:
                    ((TextView) getView().findViewById(R.id.textView1)).setText("Button 1 pushed");
                    break;
                case R.id.button2:
                    ((TextView) getView().findViewById(R.id.textView1)).setText("Button 2 pushed");
                    break;
                case R.id.button3:
                    ((TextView) getView().findViewById(R.id.textView1)).setText("Button 3 pushed");
                    break;
              }
        }
    };