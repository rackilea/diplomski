Run below code and you will get expected string.

    String text = "spiderman";
    String resultant = "";
    if(text.length() <= 2)
        resultant = text;
    else
        resultant = ""+ text.charAt(0) + text.charAt(1);
    for(int i=2;i<text.length();i++)
    {
        resultant += "-" + text.charAt(i);
    }
    System.out.println("resultant - " + resultant);