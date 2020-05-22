public Object[] populateTable(ArrayList<Outlet> outletList, String selection, int size, int monthCtr, String selDay)
{ 
    List<object> result = new List<object>();

    for(int i = 0; i<outletList.size(); i++)
    {
        if(outletList.get(i).getCity().equalsIgnoreCase(selection))
        {
            if(outletList.get(i).getStatus().equals("ACTIVE"))
            {
                bar = outletList.get(i).getBarangay();
                code = Integer.toString(outletList.get(i).getCode());
                name = outletList.get(i).getName();

                data = new Object[]{bar, name, code};
                result.Add(data);
            }
        }
    }
    return result.ToArray();
}