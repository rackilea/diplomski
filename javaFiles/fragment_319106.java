public abstract class Root<T> {
    public abstract List<T> getList();
}

public class ClassAList extends Root<ClassA> {
    @Override
    public List<ClassA> getList()  {
        List<ClassA> list = new ArrayList<ClassA>();
        // Populate list somehow
        return list;
    }
}

public class ClassBList extends Root<ClassB> {
    @Override
    public List<ClassB> getList()  {
        List<ClassB> list = new ArrayList<ClassB>();
        // Populate list somehow
        return list;
    }
}