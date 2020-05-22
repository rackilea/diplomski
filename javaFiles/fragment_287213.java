ArrayList<Insurance> policies = new ArrayList<Insurance>();
while (fileScan.hasNext())
{
    String[] array = fileScan.nextLine().split(",");
    if (array.length == 3)
    {
        policies.add(new Insurance(array[0],array[1], Integer.parseInt(array[2])));
    }
    else if (array.length == 11)
    {
        policies.add(new Property(array[0] , array[1], Integer.parseInt(array[2]),
            Integer.parseInt(array[3]), Integer.parseInt(array[4]), array[5],
            array[6], array[7], array[8], Boolean.valueOf(array[9]),
            Boolean.valueOf(array[10])));
    }
    else if (array.length == 12)
    {
        policies.add(new Auto(array[0],array[1], Integer.parseInt(array[2]),
        array[3], array[4], array[5], Integer.parseInt(array[6]), array[7],
        array[8], array[9], array[10], Integer.parseInt(array[11])));
    }

}
fileScan.close();