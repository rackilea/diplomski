// The supplied String to sort.
String suppliedString = "this is my string to sort";
// Remove all whitespaces. We don't need them for 
// this excercise since our goal is to sort and 
// get character occurrences. If you want to also
// process whitespaces then comment the code line
// below.
suppliedString = suppliedString.replace(" ", "");

// Convert the supplied string to a character array.
char[] charArray = suppliedString.toCharArray();
// Declare a Character variable to hold the current
// Character Array element value being processed.
char tempChar;
// Iterate through the character array with two
// FOR loops so as to create a string which will
// hold the least character values to the greatest
// character values.
for (int i = 0; i < charArray.length; i++) {
    for (int j = 0; j < charArray.length; j++) {
        // Is the current Array element value in 
        // charArray[i] less than the what is in
        // the current Array element for charArray[j]?
        if (charArray[i] < charArray[j]) {
            // Yes it is...
            // Hold our current character element value.
            tempChar = charArray[i];
            // Now make the Array element at index i hold
            // what is in Array element at index j.
            charArray[i] = charArray[j];
            // Make the Array element at index j hold what
            // was originally in the Array element at index i.
            charArray[j] = tempChar;
        }
        // No it's not so let's continue iterations through 
        // the character array using the index place-holder 
        // j to see if there are still more character Array 
        // element values less than what is currently in the 
        // Character Array index place-holder i location.
    }
    // continue iterations through the character array 
    // using the index place-holder i to see if there 
    // are still more character Array element values less
    // that what might be in the Character Array index place
    // -holder j location.
}

//==============================================
// For your project you don't need this little
// section. I just added it so you can see what 
// the sort looks like.
// Now use yet another FOR loop to convert the 
// the sorted Character Array (charArray[]) back
// to a sorted string.
// Declare and initialize a String variable to 
// Null String (""). This variable will hold the
// new Sorted String.
String sortedString = "";
for (int i = 0; i < charArray.length; i++) {
    sortedString+= charArray[i];
}

// Display the sorted String. If you don't
// want spaces in your sort then use: 
// System.out.println(sortedString.trim());
// Spaces have the least value (32) so they
// will almost always be at the beginning of
// the sorted string.
System.out.println("Sorted String: -->   " + sortedString + "\n");
//==============================================

// Now that the Character Array is sorted let's
// use yet another couple FOR loops to figure out
// the occurrences of each character. We'll use our 
// same String variable (sortedString) to hold our 
// display text to console. (Note: There's a lot of 
// ways to do this sort of thing in Java)
int counter; // counter used to keep track of char occurrences.
sortedString = "";
for (int i = 0; i < charArray.length; i++) {
    counter = 0; // new character. Make sure counter is zeroed
    // Iterate through the entire array and count
    // those that are the same.   
    for (int j = 0; j < charArray.length; j++) {
        if (charArray[i] == charArray[j]) {
            counter++;
        }
    }
    // Make sure we don't place duplicate character/frequencies
    // into the string we're creating.
    if (!sortedString.contains("Char: " + charArray[i])) {
        // Add the current character and occurrence
        // to our string variable.
        if (sortedString.equals("")) {
            sortedString+= "Char: " + charArray[i] + " - Freq: " + counter; 
        } 
        else {
            sortedString+= " || Char: " + charArray[i] + " - Freq: " + counter; 
        }
    }
}
// Display the sorted characters and their occurrences.
System.out.println(sortedString);