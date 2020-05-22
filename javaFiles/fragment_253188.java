if(!username.matches("[a-zA-Z0-9]+")){
    Toast.makeText(this, "Username must be alphanumeric", Toast.LENGTH_SHORT).show();
    return;
} 

if(username.matches("[a-zA-Z]+")){  // only contains letters
    Toast.makeText(this, "it should contain numbers", Toast.LENGTH_SHORT).show();
    return;
}

if(username.matches("[0-9]+")){ //only contains numbers
    Toast.makeText(this, "it should contain letters", Toast.LENGTH_SHORT).show();
    return;
}