public void onActivityResult(int requestCode, int resultCode, Intent data) 
{ 
    if (resultCode == RESULT_OK) 
    {
         if (requestCode == SELECT_PICTURE) 
         { 
            // calling GC to take care of memory, if you remove this one line of code
            // application will throw the error "VM out of memory error"
            System.gc();
            Uri selectedImageUri = data.getData(); 
            selectedImagePath = getPath(selectedImageUri); 
            imageView.setImageURI(selectedImageUri);  
       }  
   } 
}