public static String[] myMethod(ArrayList<ArrayList<String>> list) 
{
    int dim1 = list.size(); 
    int total=0;
    for(int i=0; i< dim1; i++)
        total += list.get(i).size();

    String[] result = new String[total];        

    int index = 0;
    for(int i=0; i<dim1; i++)
    {
        int dim2 = list.get(i).size();
        for(int j=0; j<dim2; j++)
        {
            result[index] = list.get(i).get(j);
            index++;
        }
    }

    return result;
}