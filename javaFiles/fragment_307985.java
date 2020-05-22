public interface ICustomClassInterface {
    String FieldA;
    int FieldB;
}

public CustomClass1 implements ICustomClassInterface {
    String FieldA;
    int FieldB;
}

ArrayList<ICustomClassInterface> arrayList = new ArrayList<ICustomClassInterface>();