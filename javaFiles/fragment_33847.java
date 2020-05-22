button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view){
                    int number = Integer.parseInt(temp.getText().toString());
                    TextView text = (TextView) findViewById(R.id.answer_text);
                    double answer;
                    int id=-1;
                    if(fahrenheit.isChecked())
                    {
                        id=1;
                    }
                    else if(celsius.isChecked())
                    {
                        id=2;
                    }
                    System.out.println("Selected option is "+id);
                    if(id == 1){
                        answer = number*1.8 + 32;     //Convert to Fahrenheit
                        text.setText("" + answer);
                    }
                    else if (id ==2){
                        answer = (number-32)/1.8;
                        text.setText("" + answer);    //Convert to Celsius
                    }
                    if(id == -1){
                        text.setText("Please select an option");
                    }

                }
            });