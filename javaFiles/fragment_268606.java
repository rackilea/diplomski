double wto=Double.parseDouble(getIntent().getExtras().getString("thetext"));//here remove the space in name 'thetext'

                            double z=wto*0.75;

                            String weight= Double.toString(z); 

                            tvr.setText(weight);