String s ="JAVA IS TOUGH LANGUAGE";
       char c ='A'; //character c is static...can be modified to accept user input
    int cnt =0;
    for(int i=0;i<s.length();i++)
        if(s.charAt(i)==c)
            cnt++;
    System.out.println("No of Occurences of character "+c+"is"+cnt);