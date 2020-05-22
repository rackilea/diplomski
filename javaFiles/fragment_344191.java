while ((strLine = reader.readLine()) != null) {
    // You might want to count lines only if they are valid!
    // If so then move this line below the IF statement code 
    // block.
    lineNumber++;    
    // Split comma separated line using ","
    String[] st = strLine.split(",");
    if (st.length == 0 || Arrays.asList(st).contains("")) {
        System.out.println("The data line (" + lineNumber + ") is blank OR "
                         + "there is a null value in the data line!");
        // Skip this data line from further processing 
        // within the WHILE loop.
        continue;
    }

    StringBuilder sb = new StringBuilder();
    sb.append("Line# ").append(lineNumber).append(": ");
    for (int i = 0; i < st.length; i++) {
        sb.append("Token : ").append(st[i]).
                // Ternary Operator used here to add commas
                append(i < (st.length-1) ? ", " : "");
    }
    System.out.println(sb.toString());      
}