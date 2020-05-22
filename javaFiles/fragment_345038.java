Public class Example{ //note: Class Names Start UpperCased!

 //this is the array that needs accessing from multiple places
 int anArray[][];

 public static void main(String args[]){
   int size = 5;

   Example example = new Example(); // create instance
   example.add1(size); //using the instance
   example.add2(size);
 }

 public void add1(int size){ //note: no static!

   //seeing as the size of the array is being defined by the user input, it's created here after being passed the size argument. 
   anArray = new int[size][size]; //you can create it here

 }

 public void add2(int size){ //note: no static
    //add more content to the array here
    //do something here
    System.out.prin
 }
}