public static List<String[]> viewSuppliers()
{
    List<String[]> lines = new ArrayList<>();
    Scanner x = null;
    try{
        x = new Scanner(new File("C:\\Users\\فاطمة\\Downloads\\suppliers.txt"));
        while(x.hasNext())
        {
            String a = x.next();
            String b = x.next();
            String c = x.next();
            String d = x.next();
            String array[] = {a,b,c,d};
            lines.add(array);
        }
        x.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    return lines;
}