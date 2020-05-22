while (rs.next())
{
String[] colValues = new String()[count];
for(int i=0; i<count;i++)
{
colValues[i] = rs.getString(i);
}
System.out.println("The current result set values are :"+colValues);
}