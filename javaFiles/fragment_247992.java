public class MyClass{

private String s;
private Integer id;
public static final Comparator MY_COMPARATOR = new MyComparator();

public MyClass(String s, Integer id){
    this.s=s;
    this.id=id;
}

@Override
public String toString(){
  return "ID :"+id+" property: "+s;
}

//Add getter&setter if you need    

//static nested class
private static class MyComparator implements Comparator<MyClass>{
      @Override
      public int compareTo(MyClass c, MyClass c2){
           //check possible nullPointerException
           int result = c.id.compareTo(c2.id);
           if(result == 0){
              return c.s.compareTo(c2.s);
           }
           return result;
      }

}

}