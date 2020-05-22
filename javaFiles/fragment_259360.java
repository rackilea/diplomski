keyList.addAll(map.keySet());
Collections.sort(keyList, yourComparator);
for (final String current : keyList)
{
    blam = map.get(current);
    ... do something with blam.
}