class C
{
 protected List sharedList;

 public void add(Object o)
 {
   sharedList.add(o);
 }
}

class B extends C
{
 public B()
 {
   sharedList=new ArrayList();
  }
}

class A extends C
{
 public A()
 {
   sharedList=new LinkedList();
  }
}