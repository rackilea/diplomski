String str = "hello";
    char[] ch = new char[str.length()];
    ch = str.toCharArray();
    for(int i=0;i<ch.length;i++){
     //this will print all the char
     System.out.println("ch len == "+ ch[i]);
     //to select specific char
     if(ch[i] == 'l'){
         System.out.println("selected chars == "+ ch[i]);
     }
    }