public int getBits() throws Exception
{

  int bits2 =  MySQL.sql.updateSQL("SELECT FROM `profiles` WHERE `UUID`= '" + u + "';");

    return bits2;
}