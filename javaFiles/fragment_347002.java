void step(){

     //get the location of the bug 
     int x = bug.x;
     int y = bug.y;

     //gets the status of the location of the bug
     Status s = status(x,y);

     //move the bug, or do something based on the status of the place

     //update the status of the location the bug was originally on
     update(x,y)
}