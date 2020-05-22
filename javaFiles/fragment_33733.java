button.setOnClickListener(new View.OnClickListener() {
 public void onClick(View v) {
   // Perform action on click 
   //Here you must get the text on your EditText
   String Answer = (String) edittext.getText().toString(); //here you have the text typed by the user
   //You can make an if statement to check if it's correct or not 
   if(Answer=="4"){
        //Create a Toast because it's correct
        Toast.makeText(MainACtivity.this, "Correct!",
   Toast.LENGTH_LONG).show();
    }
    else{
       //It's not the correct answer
       Toast.makeText(MainACtivity.this, "FAAAAAAAAIL!",
   Toast.LENGTH_LONG).show();
   }
 }
});