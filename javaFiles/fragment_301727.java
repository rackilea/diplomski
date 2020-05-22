List parts = new ArrayList();

while (sc.hasNext()) 
{
    String str = sc.readLine();

    for (String i : str.split(", ")) 
    {
        parts.add(Integer.valueOf(Integer.parseInt(i)));
    }
}