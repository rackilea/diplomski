boolean isOriginal = true;

ib_accordion1 = (ImageButton)findViewById(R.id.ib_accordion1);
                ib_accordion1.setOnClickListener(new OnClickListener() 
                {

                    @Override
                    public void onClick(View v) 
                    {
                        isOriginal = !isOriginal;
                        ib_accordion1.setImageResource(isOriginal ? R.drawable.original : R.drawable.minus_icon);                                          
                });