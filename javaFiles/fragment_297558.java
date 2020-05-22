public class ValueHolder{
    private int val1;
    private int val2;

    public void setValue1(int i){ val1 = i; }
    public void setValue2(int i){ val2 = i; }
    public int getValue1(){return val1;}
    public int getValue2(){return val2;}

    public String toString(){ 
          return String.valueOf(val1) + ", " + String.valueOf(val2);
    }
}

public class Main{

  public static void main(String[] args){

     ValueHolder vh = new ValueHolder();
     vh.setValue1(2);
     vh.setValue2(2);
     System.out.println(vh); // prints 2, 2
     input(vh);
     System.out.println(vh); // prints 1, 3
  }

  private static void input(ValueHolder vh){
      vh.setValue1(1);
      vh.setValue2(3);
  }
}