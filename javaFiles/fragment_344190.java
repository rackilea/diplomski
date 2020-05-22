while ((strLine = reader.readLine()) != null) {
    // You might want to count lines only if they are valid!
    // If so then move this line below the IF statement code 
    // block.
    lineNumber++;    
    //break comma separated line using ","
    st = new StringTokenizer(strLine, ",");

    // Is this a blank line OR Is there possibly a null token
    // in the data line detected by the String#split() method?
    if (st.countTokens() == 0 || (st.countTokens() != strLine.split(",").length)) {
        System.out.println("The data line is blank OR there is a null value "
                         + "in the data line!");
        // Skip this data line from further processing 
        // within the WHILE loop.
        continue;    
    }

    while (st.hasMoreTokens()) {
        //display csv values
        tokenNumber++;
        System.out.println("Line # " + lineNumber
                    + ", Token : " + st.nextToken(",") );
    }
    //reset token number
    tokenNumber = 0;
}