RelativeLayout rlView=  (RelativeLayout) findViewById(R.id.rlView)

        YOUR_BUTTON_CLICK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rlView.getVisibility()==View.VISIBLE)
                {
                    rlView.setVisibility(View.GONE);
                }
                else {
                    rlView.setVisibility(View.VISIBLE);
                }
            }
        });
    }