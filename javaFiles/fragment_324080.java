public class YourComparator<CustomClass> implements Comparator{
    @Override
    public int compare ( CustomClass obj1, CustomClass obj2 ) {
        return (int) (obj1.getYourProperty() - obj2.getYourProperty());
    }
}