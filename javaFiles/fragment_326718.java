public static void moveBug(Bug aBug, int n){
    for(int i = 0; i < n; i++){
        if(aBug.canMove())
           {
           aBug.move();
           } else {
           aBug.turn();
           }
       }
   }