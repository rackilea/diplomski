// The string we'll create
String abbrev = "";

// Loop over the results from the string splitting
for (int i = 0; i < result.length; i++){

    // Grab the first character of this entry
    char c = result[i].charAt(0);

    // If its a number, add the whole number
    if (c >= '0' && c <= '9'){
        abbrev += result[i];
    }

    // If its not a number, just append the character
    else{
        abbrev += c;
    }
}