String s = "ab#12#45-3";
        System.out.println(s.matches("\\d+"));

        String regex = "-#";
        String[] charArray = new String[s.length()];
        String[] stringArray = new String[s.length()];
        char[] delimArray = new char[regex.length()];

     // Not required as you can directly use regex.charAt(i)
        // Fill array with delimiter values
        /*for (int i=0; i < delimArray.length; i++) {
            delimArray[i] = regex.charAt(i);
        }
*/
        // Not required as you can directly use s.charAt(i)
        // Fill array with all values in string by character
        /*for (int i=0; i < charArray.length; i++) {
            charArray[i] = Character.toString(s.charAt(i));
        }*/

            int i = 0;
            // Outer loop
            outer:
            for (int k=0; k < s.length(); k++) {
                // Inner loop
                inner :
                for (int j=0; j < delimArray.length; j++) {
                    // The if checks the current character in the string with each delimiter character and proceeds till it checks all the delimiters 
                    if  (s.charAt(k) != regex.charAt(j)) {  
                        continue inner;                     
                    } else {
                        // Else block is reached when any of the character in the string is a delimiter
                        // Check if the current array position is null(which means nothing is assigned so far) and move to the next position only if it is not null
                        if(stringArray[i] != null) {
                            i++;
                        }
                        // Assign the delimiter in the output array
                        stringArray[i] = Character.toString(s.charAt(k));
                        // Increment to the next position in the array
                        i++;
                        continue outer;
                    }
                }
                // This if is to avoid null being appended to the string
                if(stringArray[i] == null) {
                    stringArray[i] = "";
                }
                // Add the character(since it is not a delimiter) to the current index i 
                stringArray[i] += Character.toString(s.charAt(k));
            }
        //}
        /*
         * To avoid nulls in the final split array we need to initialize one more array
         * and assign only valid values to the final split array    
         */
        String[] splitStrArr = new String[i+1];
        int m = 0;
        do {
            splitStrArr[m] = stringArray[m];
            m++;
        } while (m <= i);