button.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View p1)
        {
            Intent intent = new Intent(this, newActivity.java);
            startActivity(intent);
            finish();
        }
});