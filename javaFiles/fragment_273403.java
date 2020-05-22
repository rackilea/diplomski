private void listMenu(String CID)
{
    LISTORDER = (ListView) findViewById(R.id.listOrder);

    ArrayList<Object> data = DB.getFood(CID);
    ArrayList<HashMap<String, String>> test = new ArrayList<HashMap<String, String>>();

    for (int i=0;i<data.size();i=i+2) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(FOODNAME2, (String) data.get(i));
        map.put(PRICE, (String) data.get(i+1));
        test.add(map);
    }

    LISTMENU = (ListView) findViewById(R.id.listMenu);

    List2Adapter adapter = new List2Adapter(MainActivity.this, test);
    LISTMENU.setAdapter(adapter);
}