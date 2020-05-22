c.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     if ((name != null && name.trim().length() > 0) && (result != null && result.trim().length() > 0)) {
                                         Toast.makeText(getActivity().getApplicationContext(), "not null", Toast.LENGTH_LONG).show();

                                                 Intent intent = new Intent(getActivity(), EditClaims.class);
                                                 startActivity(intent);


                                         }
                                     else {
                                         Toast.makeText(getActivity().getApplicationContext(), "null", Toast.LENGTH_LONG).show();
                                     }
                                 }
                                     } );