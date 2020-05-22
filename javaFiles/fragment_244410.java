Map<String, String> authTable = new HashMap<String, String>();
authTable.put("D3", "R4");
...

String userInput = "D3";
System.out.println(authTable.get(userInput));   //This should yield R4, assuming that it exists.