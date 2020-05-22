spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case Cuboid: 
                       cubeT.setVisibility(View.VISIBLE);
                       cylinderT.setVisibility(View.GONE);
                    break;

                    ....
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }

        });