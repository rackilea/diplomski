SomeObject addItem(int firstnum)
{
  SomeObject o1=new SomeObject();
  o1.firstnum=firstnum;
  objectList.add(o1);
  return o1;
}
...
void callingFunction()
{
  SomeObject newObject=addItem(1);
  newObject.secondnum=2;
  ... etc ...
}