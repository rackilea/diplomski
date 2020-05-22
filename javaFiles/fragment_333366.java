//Sort them so that password < url < user for each datasource and dataSource1.* < dataSource2.*. In your case default string ordering is ok so we can take a normal SortedSet
SortedSet <String> sorted = new SortedSet<String>();
sorted.putAll(m.keySet);

//Divide keys into lists of 3
Iterable<List<String>> keyLists = Iterables.partition(sorted.keySet(), 3);


Map<String, Datasource> m = new HashMap<String, Datasource>();
for (keyList : keyLists) {
    //Contains datasourcex.password, datasroucex.url, datasourcex.user
    String[] params = keyList.toArray(new String[keyList.size()]);
    String password = properties.get(params[0]);
    String url = properties.get(params[1]);
    String user = properties.get(params[2]);
    m.put(params[0].split("\\.")[0], new DataSource(....)
}