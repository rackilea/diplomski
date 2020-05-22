mAdapter = new MainMenuAdapter(MainMenuActivity.this, dataSet, isNative, new MainMenuAdapter.OnItemClickListener(){
        @Override
        public void onItemClick(View v, int pos) {
            Intent intent = new Intent();
            if (pos == 0){
                intent = new Intent(MainMenuActivity.this, FaceDetection.class);
            } else if (pos == 1){
                intent = new Intent(MainMenuActivity.this, CircleDetection.class);
            } else if (pos == 2){
                intent = new Intent(MainMenuActivity.this, foregroundDetection.class);
            } else if (pos == 3){
                intent = new Intent(MainMenuActivity.this, Drawtivity.class);
            } else {
                Toast.makeText(getApplicationContext(), "Invalid function", Toast.LENGTH_SHORT).show();
            }
            startActivity(intent);
        }
    });