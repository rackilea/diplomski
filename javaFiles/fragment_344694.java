class MyClass 
{
    private String name;
    private int num;

    public MyClass(String name, int num)
    {
        this.name = name;
        this.num = num;
    }

    public String getName()
    {
        return name;
    }

    public int getNum()
    {
        return num;
    }
}


MyClass[] array = new MyClass[5];
array[0] = new MyClass("name1", 5);
array[1] = new MyClass("name2", 8);
...