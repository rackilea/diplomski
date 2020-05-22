void printXBaseY(int x, int y) {

          boolean active = true; 
          String first=""; //  or null
          String second=""; // or null 
          while(x >= y) {
              int a = x % y;
              int b = x / y;


               first = "" + a;
               second = "" + b;

              String answer = "" + first + second;

          }

          String answer = "" + first + second;

          System.out.println(x + " base " + y + " is " + answer);

        }