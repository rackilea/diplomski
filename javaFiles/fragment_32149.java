backbutton.setOnClickListener( new OnClickListener()
    {
        @Override
        public void onClick( View v )
        {
            finish();
            startActivity( new Intent( SecondActivity.this, FirstActivity.class ) );
            overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
        }
    });