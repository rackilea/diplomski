class MyClassA<T extends A>
{
    ArrayList<T> list;

    public MyClassA(ArrayList<T> list)
    {
        this.list = list;

...

class MyClassB extends MyClassA<B>
{
    MyClassB(ArrayList<B> list)
    {
         super(list);