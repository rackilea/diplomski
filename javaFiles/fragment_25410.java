openFloor.setOnClickListener(new View.OnClickListener(){
    public void onClick(View v){
        drawView.setRoomName(dest.getText().toString);
        startActivity(new Intent("com.example.helloworld5.FLOOR"));
    }
});