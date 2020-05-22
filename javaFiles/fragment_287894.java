mDenemeImage.setOnClickListener(new View.OnClickListener() { 
    @Override 
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK); 
        intent.setType("image/*"); 
        startActivityForResult(intent, 1); 
    }
}); 

mDenemeImage2.setOnClickListener(new View.OnClickListener() { 
    @Override 
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_PICK); 
        intent.setType("image/*"); startActivityForResult(i, 2); 
    }
}); 

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if(requestCode == 1 && resultCode == RESULT_OK){
        Uri imageUri1 = data.getData();
        resultUri1 = imageUri1;

        mDenemeImage.setImageURI(resultUri1);
    }

    if (requestCode == 2 && resultCode == RESULT_OK)
    {
        Uri imageUri2 = data.getData();
        resultUri2 = imageUri2;

        mDenemeImage2.setImageURI(resultUri2);
    }
}