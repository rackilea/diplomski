boolean hasValue = false;
while(resultSet.next())
{
    hasValue = true;
    out.println(resultSet.getString("column_name");
    out.println(resultSet.getInt("column_name");
}
if(hasValue)
    out.println("Result set has values inside of it");
else out.println("Result set has no values inside of it");