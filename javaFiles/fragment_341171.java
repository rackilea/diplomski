class Enemy {
 ...
 private int thinkVar = 1;

 public int think() {
     int thinkResult = thinkVar;
     thinkVar = (thinkVar == 1) ? 2 : 1;
     return thinkResult;
 } 
}