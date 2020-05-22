import java.util.Comparator;

public class YourComparator implements Comparator<Student>
{
    public int compare(Student o1, Student o2)
    {
        if (o1=null || o1.getTs()==null) return o2==null||o2.getTs()==null?0:-1;
        if (o2=null || o2.getTs()==null) return o1==null||o2.getTs()==null?0:1;
        if (o1.getTs().before(o2.getTs()) return -1;
        if (o1.getTs().after(o2.getTs()) return 1;
        return 0;
    }
}