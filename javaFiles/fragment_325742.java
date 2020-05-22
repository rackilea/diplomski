databasePost = FirebaseDatabase.getInstance().getReference().child("Region 1").child("Parameter Reading");

buttonDelete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        databasePost.removeValue();   
   }         
});