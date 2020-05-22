List<String[]> list = i.viewSuppliers(); // object of class
if (list.isEmpty())
    System.out.println("No current suppliers.");
else
{
    System.out.println("Current Suppliers: ");
    for (String[] supplier : list) {
        for(int u = 0; u < array3.length; u++)
        {
            System.out.printf(array3[u]);
            System.out.println(supplier[u]);
        }
    }
}