int tokenCount = 0;
    StringTokenizer tokenizer = new StringTokenizer("August 11, 2005", ",");
    while(tokenizer.hasMoreTokens()) {
        tokenizer.nextToken();
        tokenCount++;
    }
    System.out.println("token count -> " + tokenCount);