class StudentUtils
{
    public static List<Student> getDummyList(int n)
    {
        List<Student> list = new ArrayList<Student>();
        for (int i=0; i<n; i++)
        { 
            list.add(new Student(i, "Last"+i, "First"+i, 20+(i%10)));
        }
        return list;
    }

    public static List<Student> getDummyList()
    {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(0, "Foo", "Bar", 20));
        list.add(new Student(1, "Fee", "Bur", 30));
        list.add(new Student(2, "Faa", "Bir", 40));
        return list;
    }
}