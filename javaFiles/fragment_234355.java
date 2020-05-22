ImageView playButton = (ImageView) myview.findViewById(R.id.play_btn);
playButton.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
       Toast.makeText(FloatingViewService.this, "Playing the song.", Toast.LENGTH_LONG).show();
   }
});

//change this as your per your requirement