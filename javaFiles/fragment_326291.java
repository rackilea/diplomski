public void first()
{
    int i = 5;
    Value v = new Value();
    v.i = 25;
    second(v, i);
    System.out.println(v.i);
}