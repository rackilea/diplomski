public static byte[] UrlTokenDecode(String input) { 
    if (input == null)
        return new byte[0];

    int len = input.length(); 
    if (len < 1)
        return new byte[0]; 

    ///////////////////////////////////////////////////////////////////
    // Step 1: Calculate the number of padding chars to append to this string. 
    //         The number of padding chars to append is stored in the last char of the string.
    int numPadChars = (int)input.charAt(len - 1) - (int)'0';
        if (numPadChars < 0 || numPadChars > 10)
            return null; 


    /////////////////////////////////////////////////////////////////// 
    // Step 2: Create array to store the chars (not including the last char)
    //          and the padding chars 
    char[] base64Chars = new char[len - 1 + numPadChars];


    //////////////////////////////////////////////////////// 
    // Step 3: Copy in the chars. Transform the "-" to "+", and "*" to "/"
    for (int iter = 0; iter < len - 1; iter++) { 
        char c = input.charAt(iter); 

        switch (c) { 
            case '-':
                base64Chars[iter] = '+';
                    break;

                case '_':
                base64Chars[iter] = '/'; 
                break; 

            default: 
                base64Chars[iter] = c;
                break;
        }
    } 

    //////////////////////////////////////////////////////// 
    // Step 4: Add padding chars 
    for (int iter = len - 1; iter < base64Chars.length; iter++) {
        base64Chars[iter] = '='; 
    }

    // Do the actual conversion
    String assembledString = String.copyValueOf(base64Chars);
    return Base64.decodeBase64(assembledString);
}