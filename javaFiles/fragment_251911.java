public class Methods {
    public void Translator(String s, String[] index, int location) {
        System.out.println("Index Length: " + index.length);
        System.out.println("Location: " + location);
        if (location >= index.length)
            System.out.println("Uppss.. ArrayIndexOutOfBoundException :((( ");
        while (index[location].length() > 0) { 
          location++; 
          if(index.length > 0) {
              s = s + index[location].substring(1) 
                    + index[location].substring(0,1).toLowerCase() 
                    + "ay";
          }
          System.out.println(s);
       } 
   }
}