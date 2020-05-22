public class Student {

    private double mark;
    private String name;

    public Student()
    {
        mark = 0;
        name = "";
    }

    public Student(int mark, String name)
    {
        this.mark = mark;
        this.name = name;
    }

    public double getMark()
    {
        return mark;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setMark(double mark)
    {
        this.mark = mark;
    }

}