public void onClick(View view){
    //This casts your view to be a button so you can access its features as a button
    Button btn = (Button) view;
    textViewString = tv.getText().toString();

    if(!btn.getText().toString().equals(textViewString)){
         //Perform action to notify user that they pressed the wrong button
         //Do not return here. This is what caused your program to lock up
         //Maybe add a TextView that says correct/incorrect and you can change that when the user is correct or incorrect
    }

    //Gets a random color from your string array and sets it to the TextView
    q = myString[r_generator.nextInt(myString.length)];
    tv.setText(q);
}