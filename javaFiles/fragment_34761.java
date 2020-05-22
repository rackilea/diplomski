blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardNumber = 1;
                FinalSubmit fragment = new FinalSubmit();
                Toast.makeText(getContext(), "Blue", Toast.LENGTH_SHORT).show();
                getContext().getSharedPreferences("pref",0)
                        .edit().putInt("int",cardNumber).apply();
                FragmentTransaction ft4 = getFragmentManager().beginTransaction();
                ft4.replace(R.id.frameLayout, fragment4, "FragmentName");
                ft4.commit();

            }
        });