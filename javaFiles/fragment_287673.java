String s = "1 0.24887:1 0.64811:1 0.5987:1 0.39418:1 0.96313:1 0.92772:1 1:1";
     String[] sp = s.split(" ");
     String[] parsedLastToken = sp[sp.length-1].split(":");
     for (int i = 0; i < parsedLastToken.length; i++) {
          System.out.println(parsedLastToken[i]); 
    }