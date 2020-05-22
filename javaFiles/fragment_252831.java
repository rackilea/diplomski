mAdapter.setOnItemClickListener(new LensAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(int position) {
           //Crea String con la informacion de posicion y texto del lente
            String lensPosition = lensList.get(position).getLens();
            lensString = lensPosition;
            Intent lensIntent = new Intent(LensActivity.this,MainActivity.class);
            lensIntent.putExtra("LensIntent",lensString);
            Toast.makeText(getApplicationContext(),"this is " + lensString , Toast.LENGTH_SHORT).show();
            startActivity(lensIntent);
        }
    });