public interface ICustomClassInterface {

}

public class CustomClass1 implements ICustomClassInterface {
    String title, description;
    int amount;
}

ArrayList<ICustomClassInterface> arrayList = new ArrayList<ICustomClassInterface>();