btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(count >= 5)
                {
                   Toast.makeText(getBaseContext(), "No more EditText Box to add.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                  count++;

                  if(count == 3)
                   inputOptionName3.setVisibility(View.VISIBLE);
                  else if(count == 4)
                   inputOptionName4.setVisibility(View.VISIBLE);
                  else if(count == 5)
                   inputOptionName5.setVisibility(View.VISIBLE);
                }
            }
        });

 cancel.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(count <= 2)
                    {
                        Toast.makeText(getBaseContext(), "No more EditText Box to cancel.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                     if(count == 3)
                     inputOptionName3.setVisibility(View.GONE);
                     else if(count == 4)
                     inputOptionName4.setVisibility(View.GONE);
                     else if(count == 5)
                      inputOptionName5.setVisibility(View.GONE);

                     count--;
                    }
                }
            });