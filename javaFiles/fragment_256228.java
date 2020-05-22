ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

for (int i=0; i<13; i++)
{
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("left1", date[i]);
    map.put("right1", name[i]);
    mylist.add(map);
}