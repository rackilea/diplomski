public void buildSuppliersWithLoop()
{
    ArrayList<Supplier> registers = new ArrayList<>()
    int numberOfSuppliers = 100;
    for (int i = 0; i < numberOfSuppliers; i++)
    {
        registers.add(new Supplier(i));
    }
}

public void buildSuppliersWithStream()
{
    int numberOfSuppliers = 100;
    List<Supplier> registers = IntStream.range(0, numberOfSuppliers)
            .mapToObj(Supplier::new)
            .collect(Collectors.toList());
}

public class Supplier
{
    private int number;
    private List<Warehouse> materials;

    public Supplier(int number)
    {
        this.number = number;
        this.materials = new ArrayList<>();
    }
}

public class Warehouse
{
}