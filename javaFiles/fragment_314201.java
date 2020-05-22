class Student{
    //add variables, constructors and methods here
    String name = "";
    String height = "";
    int grades [] =new int [10];

    public void initGrades()
    {
        for(int i = 0; i < grades.length; i++)
        {
            grades[i] = rand(60,99);
        }
    }


    public Student(String n, String h, int g[])
    {
        name = n;
        height = h;
        grades = g;
        initGrades();
    }

}