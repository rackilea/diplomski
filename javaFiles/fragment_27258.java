int initial_col = // the x coordinate that you're starting from ;
int initial_row = // the y coordinate that you're starting from ;
for( int x = initial_col ; x < list.length && x + (initial_col - initial_row) < list[0].length ; i++){
  System.out.println("x index: " + x); //Check it for debugging
  int y = x + (initial_col - initial_row); //This is the y = x + b problem we looked at earlier
  System.out.println("y index: " + y); //Also for debugging
  list[x][y] ... // What you want to do with that point
}