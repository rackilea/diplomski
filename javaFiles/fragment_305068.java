public void onClick (View View){
Intent i = new Intent (Order. this, Confirmation.class);
i.putStringArrayListExtra("myArrayList",klickademackor);

startActivity(i);
}}