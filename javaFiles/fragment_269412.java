kerko.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(),("stringu= "+Stringat.int1+"   stringu2="+Stringat.int2+""),Toast.LENGTH_SHORT).show();

                if(Stringat.int1 == 1 && Stringat.int2 == 1)
                     linjaText.setText("Linja 5");
            }
        });

linjaeDuhur.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Toast.makeText(getActivity(),("stringu= "+Stringat.int1+"   stringu2="+Stringat.int2+""),Toast.LENGTH_SHORT).show();

                if(Stringat.int1 == 1 && Stringat.int2 == 1)
                {
                     Intent i = new Intent (getActivity(), Linja.class);
                     startActivity(i);
                }
            }
        });