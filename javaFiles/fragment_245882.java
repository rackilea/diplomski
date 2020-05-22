Button btn = (Button) findViewById(R.id.btn);
 btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (intent != null) {
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "No choice made yet", Toast.LENGTH_SHORT).show();
                        }


                    }

                });