List<Car> duplicates = new ArrayList<Car>();
Set<Car> carSet = new TreeSet<Car>(new CarComparator());
for(Car c : originalCarList)
{
    if(!carSet.add(c))
    {
        duplicates.add(c);
    }
}