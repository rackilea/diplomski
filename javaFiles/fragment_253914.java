if(hashMap.containsKey(courseGroup.getKey().get(0)))
{
    hashMap.get(courseGroup.getKey().get(0)).add(attachment);
}
else
{
    List<Person.Personal> list = new ArrayList<>();
    list.add(attachment);
    hashMap.put(courseGroup.getKey().get(0), list);
}