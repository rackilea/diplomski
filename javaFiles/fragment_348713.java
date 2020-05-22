while((value = reader.read()) != -1)
{
     // Convert int to a character
     char c = (char)value;


      // Searching for the separator
      if (c == ','){
           if (state == 1) {
                state = 2;
           } else {
                state = 0;
                strb.append(c);
            }
       }
       else if (c == '"'){
            if (state == 2){
                 // The separator if found, read the string
                 processElement(strb, counter); 

                  // Prepare to read a new string
                  state = 0;
                  counter ++;

             } else {
                  state = 1;
                  strb.append(c);
             }
       } else {
             strb.append(c);
       }
}

// Process the last element
processElement(strb, counter);


public void processElement(StringBuilder strb, int counter){
    String str = strb.toString().replaceAll("^\"|\"$", "");
    System.out.println("String to process= " + str);

    /*
         Do something with it here..

    switch (counter) {
        case 1:  Description = str;
        break;

        case 2:  Band = str;
        break;

        ...
    }
    */

    // Initialize the string builder
    strb.setLength(0);
}