String example="Value = \"Welcome to the restaurant\""; //replace with EditText value

    int firstQuoteIndex=example.indexOf("\"")+1;
    int lastQuoteIndex=example.lastIndexOf("\"");

    String result=example.substring(firstQuoteIndex, lastQuoteIndex);