btnActivity.setOnClickListener(new View.OnClickListener() 
        {   
            @Override
            public void onClick(View v) {
            wm.removeView(myView);
            finish();
            }
        });