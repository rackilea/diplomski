String result = "";
    String s = "10,25,12,25,30";

    // Split string using String Tokenization
    String tokens[] = s.split(",");
    for(String token : tokens) {
        result += "("+token+"),";
    }

    // To remove the last comma 
    result = result.substring(0, result.length()-1);