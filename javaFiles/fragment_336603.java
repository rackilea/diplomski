move_found.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MakeupMenu.this, MakeupActivity.class);
            intent.putExtra("data,"button1");
            startActivity(intent)
        }
    });


move_conc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MakeupMenu.this, MakeupActivity.class);
            intent.putExtra("data","button2");
            startActivity(intent);
        }
    });