public void second(Value v, int i)
{
    i = 0;
    v.i = 20;
    Value val = new Value();
    v =  val;
    System.out.println(v.i + " " + i);
}