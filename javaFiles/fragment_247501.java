public static String listToString(List<Object> list)
{
    String listConcat = "";
    for(int i = 0; i < list.size(); i++)
    {
        String num = String.valueOf(list.get(i));
        if((i + 1) != list.size())
        {
            listConcat += num + ",";
        }
        else
        {
            listConcat += num;
        }
    }
    return listConcat;
}

public static void main(String[] args)
{
    List<Object> list = new ArrayList<Object>();
    list.add(1.2345);
    list.add(2.2345);
    System.out.println(listToString(list));
}