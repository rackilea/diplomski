while(rs.next())
{
    String[] recordSet = new String[paramters.length]; // <-- make a new one.
    for(int i = 0; i < parameters.length; i++)
    {
        recordSet[i] = rs.getString(parameters[i]);
    }
    System.out.println("After for loop " + recordSet[0] 
        + " " + recordSet[1] + " " + recordSet[2]);
    ar.add(recordSet);
}