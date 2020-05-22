int x = e.getX();        
 /*here i wanted to get a left or right motion by using x1 and x2
            so that ball can be directed accordingly*/
 if(x>prevx) ballXS=10; // right
 if(x<prevx) ballXS=-10; // left
 prevx=x;