home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(p1.this,MainActivity.class);
                startActivity(intent);
                storeCurrentActivity();
                this.finish();

            }
        });