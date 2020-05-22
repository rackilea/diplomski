String test = "test\r\ncase";

//Print the character before
for(char c : test.toCharArray()){ System.out.print((int)c + " ");};
System.out.println();

//Save the replace result
test = test.replaceAll("\r\n","\n");

//Print the character after
for(char c : test.toCharArray()){ System.out.print((int)c + " ");};