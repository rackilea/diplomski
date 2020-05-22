view.setOnClickListener(new View.OnClickListener() {    
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            Intent i = new Intent(MainActivity.this, Sqlview.class);
            startActivity(i);

        }
});