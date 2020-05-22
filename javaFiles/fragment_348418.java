class MyFunctionOutput
{
     List list;
     boolean b;
}

MyFunctionOutput myFunction(int x, int y)
{
     MyFunctionOutput out = new MyFunctionOutput();
     out.list = anotherList.subList(....);
     out.b = true;
     return out;
}