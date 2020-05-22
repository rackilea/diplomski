public class Example{

  Example(String s[])
  { 
   AnotherClass ac = new AnotherClass(s);
  }
  public static void main(String[] args){
  int num=args.length;
  String s[]=new String[num]; 
  Example ex = new Example (s);`
  }
}