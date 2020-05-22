Map<String, Integer> map = new HashMap<>();
for(int i = 0; i < secondList.size(); i++)
{
    map.put(secondList.get(i), i + 1);
}
for(int i = 0 ; i < firstList.size() ; i++)
{
    System.out.println(map.get(firstList.get(i)));
}