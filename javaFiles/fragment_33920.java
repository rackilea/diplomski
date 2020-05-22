Table myTable =null;
else default to 20, 10, and fill randomly 1/4 
  { 
    int a = 20; 
    int b = 10; 
    myTable = new Table(a,b); 
    myTable.randomfill(Math.round((a*b)/4)); //round in case defaults change later 
    System.out.println("Printing Table .... "); 
    myTable.print();  <-- here it works 
  } 

  //always print !! 
  System.out.println("Printing Table .... "); 
if(myTable != null){  //Make sure myTable is not null.
  myTable.print(); <-- won't work 
}