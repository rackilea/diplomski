public class CarComparator implements Comparator<Car>
{
    public int compare(Car c1, Car c2)
    {
        return c1.carName.compareTo(c2.carName);
    }
}