String text = "His_PRP$ plays_NNS remain_VBP highly_RB popular,_JJ and_CC are_VBP constantly_RB studied._VBN";
 String pattern = "([^\\s]+_(NNS|CC))";
 String resultText = "";

    // Create a Pattern object
    Pattern r = Pattern.compile(pattern);

    // Now create matcher object.
    Matcher m = r.matcher(text);
    while (m.find( )) 
    {
      resultText = resultText + m.group(0) + " ";
    }

    System.out.println("RESULT: " + resultText);

    /*
    #### OUTPUT #####
    RESULT: plays_NNS and_CC 
    */