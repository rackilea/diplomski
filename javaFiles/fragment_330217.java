Image fist
 Image enemy
    //in paint

g2D.drawImage(fist,x,y,this);

g2D.drawImage(enemy,x1,y1,this);

Rectangle2D myFist = new Rectangle2D.Double(x,y,fist.getWidth(this),fist.getHeight(this));
Rectangle2D myEnemy = new Rectangle2D.Double(x1,y1,enemy.getWidth(this),enemy.getHeight(this));
if (myEnemy.contains(myFist){
//action u want to happend
}