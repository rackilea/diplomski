sec.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {

         totalTime=System.currentTimeInMillis()-startTime;

          Intent intent = new Intent(Game.this, MainScreen.class);
          intent.putExtra("time",totalTime);
          startActivity(intent);

    }
}