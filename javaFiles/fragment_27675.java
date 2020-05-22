import java.util.ArrayList;
 import java.util.List;

 public class demo {
 public static void main(String[]args){
    List<Integer>list1=new ArrayList<Integer>();
    List<Integer>list2=new ArrayList<Integer>();
    List<Integer>list3=new ArrayList<Integer>();
    ////here add your values to the list,i have not added them.You  first need to add the values to the list
    //then iterate through your list
    //create a list of your own custom class
    List<object>finallist=new ArrayList<object>();
    for (int i=0;i<list1.size();i++){
    finallist.add(newobject(list1.get(i),list2.get(i),list3.get(i)));//use new keyword to instantiate or  create a reference of a new object
    }
    //now your finallist contains your required data
}
  static class object{//create your custom class
  int A,B,C;

  public object(int a, int b, int c) {define a constructor
      A = a;
      B = b;
      C = c;
     }
   }
 }