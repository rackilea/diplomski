public class B extends class A{
 Rectangle[] mPathDots=new Rectangle[30]; //initialized array with 30  nulled items

 public B(){
   int x = mPathDots.length; //error! mPathDots is null, but in theory lenght must be 30 !?
 }
}