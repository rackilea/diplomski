String strWithDelimeter = "Hello_Hi_Good_Morning";

    StringTokenizer strToken = new StringTokenizer(strWithDelimeter, "_");
    int noOfToken = strToken.countTokens();
    int count =1;
    String currentElement = null, lastElement = null,lastElement2 = null;
    while(strToken.hasMoreTokens()) {
        currentElement = strToken.nextToken().toString();
        if(count == noOfToken)
            lastElement = currentElement;
        else if(count == noOfToken-1)
            lastElement2 = currentElement;
        else 
            System.out.println(currentElement);
        count++;
    }
    System.out.println(lastElement2+"_"+lastElement);