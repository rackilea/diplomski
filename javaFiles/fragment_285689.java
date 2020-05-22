send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent intent = new Intent(getApplicationContext(),Next.class);
                final Bundle b = new Bundle();

                b.putString("age",age.getText().toString());

                int checked = jk.getCheckedRadioButtonId();
                b.putString("checked", checked);


                intent.putExtras(b);
                startActivity(intent);

            }
        }