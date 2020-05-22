int cnt=2;

while(rs.next()) 
{
    data.put(""+cnt, new Object[] {1d, "John", 1500000d, "Test"});
    cnt++;//increment to 3, 4, etc
}