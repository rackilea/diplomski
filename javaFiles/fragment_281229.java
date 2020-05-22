b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

         // 
               String text = e1.getText().toString();
               String text2 = e2.getText().toString();
               String text3 = e3.getText().toString();
              ((Saver) SHGDetails.this.getApplication()).setShg1(text);
              ((Saver) SHGDetails.this.getApplication()).setShg2(text2);
              ((Saver) SHGDetails.this.getApplication()).setShg3(text3);

                l.removeView(e1);
                l.removeView(e2);
                l.removeView(e3);
                l.removeView(b1);

                getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                        .putBoolean("isFirstRun", false).commit();


            }
        });