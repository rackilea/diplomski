public int getBits() throws Exception
{

  ResultSet set =  MySQL.sql.executeQuery("SELECT bits FROM `profiles` WHERE `UUID`= '" + u + "';");

  if(set.next())
      return set.getInt("bits");

  return 0;
}