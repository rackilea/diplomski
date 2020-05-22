public static String translateHeaderChecksum(String headerChecksum) {
    // Declare and initialize required variables
    // Tokenize the contents of the headerChecksum string
    // variable into an Array based on the dashes (-) within
    // the string.
    String[] tokens = headerChecksum.split("-");
    String binaryString = "";
    String binaryValue = ""; 

    // Interate through the tokens[] Array and carry out convertions
    // such as convert number strings to integer and then the integer
    // numbers to the desired binary strings. The switch/case within
    // the 'for loop' handles our tranlation model as to what we're
    // going to do with each each part of the header checksum string.
    // Remember, each of those parts are now contained within the 
    // tokens[] string Array.
    for (int i = 0; i < tokens.length; i++) {
        int hcn = 0;
        // Convert the string number contained within the tokens[] Array
        // to integer so as to prep supply to the integerToBinaryString()
        // method.We only do elements 0 to 9 because elements 10 and 11
        // contain IP addresses and need to be handled separately. See 
        // case 11 & case 12 below).
        if (i >= 0 && i<=9) {
            hcn =  Integer.valueOf(tokens[i]);
        }

        // Handle each header checksum value, convert to binary
        // and ensure proper bit count.
        switch (i+1) {
            case 1: case 2: 
                binaryValue = integerToBinaryString(hcn,4);
                break;
            case 3:
                binaryValue = integerToBinaryString(hcn,8);
                break;
            case 4: case 5:
                binaryValue = integerToBinaryString(hcn,16);
                break;
            case 6:
                binaryValue = String.format("%0" + 3 + "d", hcn);
                break;
            case 7: 
                binaryValue = integerToBinaryString(hcn,15);
                break;
            case 8:
                binaryValue = binaryValue + integerToBinaryString(hcn,4);
                break;
            case 9: 
                binaryValue = integerToBinaryString(hcn,8);
                break;
            case 10:
                binaryValue = integerToBinaryString(hcn,16);
                break;
            case 11: case 12:
                // Handle the two IP addresses located at the end of
                // Header Checksum string. Place each number of the IP 
                // into a string Array variable named ipTokens[] but 
                // first we need to get rid of the periods since split()
                // doesn't play well with them, We'll change them with
                // commas (,).
                tokens[i] = tokens[i].replace('.',',');
                String[] ipTok = tokens[i].split(",");
                // Iterate through each number of the IP address we're
                // currently working on and convert it to a binary string.
                for (int j = 0; j < ipTok.length; j++) {
                    // Since the our final two binary number strings are 
                    // in fact each IP address number converted to a 8-bit
                    // binary number and all pushed together (appeneded) to
                    // one another to form a 32-bit binary number, we do that
                    // here.
                    binaryValue = binaryValue + integerToBinaryString(Integer.valueOf(ipTok[j]),8);
                }
                break;
        }

        // Here we compile our final binary string. For every
        // interation we append our determined binary number
        // strings to it.
        // We skip the application of case 7 to our final binary
        // string because case 8 is appended to it (see case 8).
        if ((i + 1) != 7) {
            binaryString+= " " + binaryValue;
            binaryValue = "";
        }
    }
    // Trim off any leading or trailing spaces we had 
    // applied to the final binary string.
    binaryString = binaryString.trim();

    // Return our final binary string.
    return binaryString;
}