d.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent mafhoom = new Intent(Main.this, Second.class);
            mafhoom.putExtra("Selectedpassage", matn.getText().toString());
            startActivity(mafhoom);
        }

    });