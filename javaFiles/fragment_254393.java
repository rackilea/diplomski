Public class SecondClass{

private static int rye = 150;
private static int white = 120; //static for a call like that
public int decision;

 public static  void breadCals () { 
   //method needs to be static to call it like i did
  int sel=FirstClass.decision;
  int  r = rye;
  int  w = white;
  if (sel == 1) System.out.println("you entered 1 " + r);
  else if(sel== 2) System.out.println("you entered 2 "+ w);
  else System.out.println("Wrong number"); 

    }
}