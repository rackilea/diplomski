public static void main(String[] args) {
        String s="ab !@#$&*()//CcAB897987";
         List upperChar=new ArrayList();
         String a = s.replaceAll( "[^A-Z\\-]", "" );  // remove all character other Uppercase character
         char []ch=a.toCharArray();              // this contains all uppercase character
         for (int i = 0; i < ch.length; i++) {
               upperChar.add(ch[i]);             // make a list of uppercase char.
         }

           System.out.println(upperChar);

 }