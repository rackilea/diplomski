for ( int q = 1; q < b; q++) {

                    myButton = new Button(this);

                    final int number = new Random().nextInt(9);      
                final int rand = (ids[number]);
                    myButton.setText(""+rand);
                myButton.setTypeface(type);
                myButton.setId(rand);
                myButton.setTag(rand);
               arrayButton.add(myButton);
                }