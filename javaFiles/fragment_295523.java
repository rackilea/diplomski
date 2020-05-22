//specify the button that has to handle visibility  
ImageButton properties = (ImageButton) findViewById(R.id.propBtn);

//And the layout we want to change is visibility
final LinearLayout propLayout = (LinearLayout) findViewById(R.id.properLayout);

            properties.setOnClickListener
            (
                    new View.OnClickListener()
                    {
                        public void onClick(View v)
                        {
                            if (propLayout.getVisibility() == View.VISIBLE)
                            {
                                propLayout.setVisibility(View.INVISIBLE);
                            }
                            else
                            {
                                propLayout.setVisibility(View.VISIBLE);
                            }
                        }
                    }
            );