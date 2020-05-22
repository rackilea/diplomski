int oldIndex = 0;  // to maintain the end index of previous word.
int length = input.length();
for (int i = 0 ; i < length; i ++) {

          if (input.charAt(i) == ' ' || i == length - 1) {

                // If the word is at the end, then probably your first 
                // condition in above `if` would fail, that is why I used a 
                // second condition, which checks the end of string

                // Now for the end of the string, we would need to use a single
                // arguement substring method to get the word till the end.
                // hence the below conditional expression.

                String check = (i == length - 1)? input.substring(oldIndex): 
                                                input.substring(oldIndex, i);

                oldIndex = i + 1;  // Set oldIndex to the next index.

                if (check.length() >= wordlength) {

                    count++;
                    //  input = input.substring(i);  Don't do this
                    // break;   // Don't break too.

                }
           }

}