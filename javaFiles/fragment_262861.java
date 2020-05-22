Scanner keys = new Scanner(System.in);

 int x = 0;
 int y = 0;

 public void getInput() {

 x = keys.nextInt();
 y = keys.nextInt();
 createart();

 }

 public void createart() {

 System.out.print("00");

 int counter = 0;

 while (counter < x - 4) {

 System.out.print(1);

 counter++;

 }
 System.out.println("00");

 counter = 0;
 System.out.print("0");
 while (counter < x - 2) {

 System.out.print(1);
 counter++;

 }
 System.out.print("0");
 counter = 0;
 int counter2 = 0;
 while (counter < y - 4) {
 System.out.println("");

 while  (counter2 < x) {

 System.out.print(1);

 counter2++;
 }
 counter++;
 } 
 System.out.println("");
 counter = 0;
 while (counter < x - 2) {

 System.out.print(1);

 counter++;

 }

 counter = 0;
 System.out.println("0");
 System.out.print("00");
 while (counter < x - 4) {

 System.out.print(1);

 counter++;

 }

 System.out.print("00"); 

 }