play.setOnClickListener(new OnClickListener() {
    Override
    public void onClick(View v) { 

        if (db.difficultyeasy() == 1) {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);

        } 
        else if(db.difficultyhard() == 3){
            Intent intent = new Intent(MainActivity.this, HardMode.class);
            startActivity(intent);
       }
});