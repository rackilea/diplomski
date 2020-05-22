public static void main(String args[]){

          String userInput = new String("ABCDEFG123456");

          String variable1 = userInput.substring(1,5);
          String variable2 = userInput.substring(6, userInput.length());

          System.out.println(variable1);
          System.out.println(variable2);

       }