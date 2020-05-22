List<String> temp = new ArrayList<String>();
String statement1 = " select sentence from sentences  ";
PreparedStatement preparedstatement = conn.prepareStatement(statement1);
try
{
    ResultSet res = preparedstatement.executeQuery();

    while (res.next())
    {
       temp.add(res.getString("sentence"));
    }
}
finally{
    preparedstatement.close();
}
String[] temp2 = temp.toArray(new String[0]);