String[] word=input.split("\\bfrom\\b\\s+(?=\\d)|\\bto\\b\\s+(?=\\d)");

System.out.println("Text 1: "+word[0]);

System.out.println("Text 2: "+word[1]);

System.out.println("Text 3: "+word[2]);