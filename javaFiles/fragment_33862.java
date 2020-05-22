//declare the array of size 3
ClassOfStaticMethods[] SyskPin = new ClassOfStaticMethods[3]; 

//loop through the array
for (int i = 0; i < 3; i++) { 
     int kati = 5;
    //create a new instance 
    ClassOfStaticMethods clas = 
        new ClassOfStaticMethods(2, 2.1, "something", 90, 100, kati);

     //assign the new instance 
     //to the place holder in the array based on the index
     SyskPin[i] = clas; 
}