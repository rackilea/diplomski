List<ArrayList<String>> resultSet = new ArrayList<>();
for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet())
{
      if(inputArrayList.contains(entry.getKey())){
           resultSet.add(entry.getValue());
      }
}