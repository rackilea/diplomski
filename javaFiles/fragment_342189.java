class SomeObjectWrapper
{
  public SomeObject someObject;
}
...
void addItem(int firstnum, SomeObjectWrapper sow)
{
  SomeObject o1=new SomeObject();
  o1.firstnum=firstnum;
  objectList.add(o1);
  sow.someobject=o1;
}
...
void callingFunction()
{
  SomeObjectWrapper sow=new SomeObjectWrapper();
  SomeObject newObject=addItem(1, sow);
  sow.someObject.secondnum=2;
  ... whatever ...
}