static <V> List<V> NMapToList(NavigableMap<Integer,V> nmap, V emptyEntryValue)
{
    Integer next = null;
    List<V> list = new ArrayList<V>();

    for(NavigableMap.Entry<Integer, V> e : nmap.entrySet())
    {
        Integer current = e.getKey();

        if(next != null)
            for(int i = next; i < current; i++)
                list.add(emptyEntryValue);
        list.add(e.getValue());

        next = current + 1;
    }

    return list;
}

static String listToString(List<?> l, String separator)
{
    StringBuilder sb = new StringBuilder("(");
    String sep = "";
    for (Object object : l)
    {
        sb.append(sep).append(object.toString());
        sep = separator;
    }
    return sb.append(")").toString();
}

String s = listToString(NMapToList(nmap,'-'),',');