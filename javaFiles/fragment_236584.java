public static void main(String[] args){
            int number = 5;
              String word = new String("");
              word = "Valentine";
              String method = Recurcive.method1(number, word);
              System.out.println(method);
           }

           public static String method1(int number, String word){
              if (number <= 0){
                 return "";
              } 
              else{
                 return number + " " + word + ", " + method1(number - 1, word.substring(1));
              }
           }