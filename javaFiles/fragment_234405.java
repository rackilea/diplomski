public static void main(String[] args) {
long n = 50;
System.out.print("1 ");
long x = 0;
long y = 1;

String mult3 = "cheese";
String mult5 = "cake";
String mult7 = "factory";
String mult2 = "blah";

for (long i = 1; i < n; i++) {
    long forSum = x + y;
    x = y;
    y = forSum;

    if(forSum==89){
        continue;
    }
    if(forSum==10946){
        continue;
    }
    if(forSum==1346269){
        continue;
    }
    if(forSum==165580141){
        continue;
    }

    if(forSum %3 == 0){
        //String mult3 = String.valueOf(forSum); 
        //String mult4 = "cheese";
        //String mult3cheese = mult3.replaceAll(mult3, mult4);
        //System.out.print(mult3cheese);
        System.out.print(mult3 + " ");
        continue
    }
    if(forSum %5 == 0){
        System.out.print(mult5 + " ");
        continue;
    }
    if(forSum %7 == 0){
        System.out.print(mult7 + " ");
        continue;
    }

    if(forSum %2 == 0){
        System.out.print(mult2 + " ");
        continue;
    }
    System.out.print(forSum + " ");
  }//for loop for forSum
}//public static void main