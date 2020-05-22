ImageButton ib=(ImageButton)findViewById(R.id.ib);
ib.setOnClickListener(ibLis);
    }
    private OnClickListener ibLis=new OnClickListener(){

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            //START YOUR ACTIVITY HERE AS
             Intent intent = new Intent(YOUR_CURRENT_ACTIVITY.this,NextActivity.class);
             startActivity(intent, 0);
        }
    };