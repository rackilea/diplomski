public class MySQLEntry {
    public String bellname;
    public String date;
}
// ...
Gson gson = new Gson();
MySQLEntry[] entryArray = gson.fromJson(yourJsonString, MySQLEntry[].class);