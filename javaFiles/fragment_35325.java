import java.util.LinkedList;

public class SingleList<T>
{
    private LinkedList<T> internal;

    SingleList()
    {
        this.internal = new LinkedList<>();
    }

    public void add(T addName)
    {
        this.internal.addFirst(addName);
    }

    @Override
    public String toString()
    {
        if(!this.internal.isEmpty())
        {
            return this.internal.get(0).toString();
        }
        else
        {
            return this.internal.toString();
        }
    }

    public static void main(String[] args)
    {
        SingleList<name> nameList = new SingleList<>();
        name name1 = new name("John", "Smith");
        nameList.add(name1);
        System.out.println("LinkedList contains : " + nameList);
    }
}