String[] nameList = {"Sam", "Harry", "Ron"}; //Store the list as you like
int index i = 0;    

//put the correct id of the TextView from the xml file
TextView nameTextView = (TextView) findViewById(R.id.nameTextView);

//put the correct id of the Button from the xml file
Button button = (Button) findViewById(R.id.button1);

//set the OnclickListener and define what you want to happen in the onClick() method

button.setOnClickListener(new OnclickListener() {
    nameTextView.setText(nameList[index]); //set the name in the index as text
    if((index+1) >= nameList.length)
        index++; //increase the index by 1, for the next time.
    else
        index = 0; // to loop back to the first name.
});