btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(LayoutActivity.this,MainActivity.class);
            intent.putExtra("TEL","65421321");
            startActivity(intent);
            finish();
        }
    });