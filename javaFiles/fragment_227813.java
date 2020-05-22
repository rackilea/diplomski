@Override
public int compare(Student o1, Student o2) 
{
    int result = o1.grade - o2.grade;

    return (result != 0) ? result : o1.name.compareTo(o2.name);
}