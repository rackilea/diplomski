ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();

JSONArray arr = new JSONArray(<JSON STRING HERE>);

for(int i = 0; i < arr.length(); i ++)
{
    JSONObject obj = arr.getJSONObject(i);
    JSONArray valueArray = obj.getJSONArray("values");

    ArrayList<Integer> dataList = new ArrayList<Integer>();
    resultList.add(dataList);

    for(int j = 0; j < valueArray.length(); j ++)
    {
        JSONObject valueObject = valueArray.getJSONObject(j);
        Integer value = valueObject.getInt("value");
        dataList.add(value);
    }
}