public object GetValues (string status)
{
   string query = "SELECT KEY_COMPANY, KEY_POSITION, KEY_NOTES, KEY_WAGE,KEY_STATUS 
   FROM DATABASE_TABLE 
   WHERE KEY_STATUS = "'" +status+ "'" " ;

   dbcomands part...

   List<object> =  execute db comand....
}