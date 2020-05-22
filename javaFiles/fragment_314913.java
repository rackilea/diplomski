Hashtable myHashTable = new Hashtable(passingToN);
.....
// ArrayAddingScreen needs to read/write myHashTable so we will pass it
nextStage = new ArrayAddingScreen(firstStage, myHashTable);

// OR
// create a setter method in ArrayAddingScreen class

public void setMyhashTable (Hashtable myHashTable) {
   this.myHashTable = myHashTable;
}