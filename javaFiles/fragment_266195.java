List<Integer> list = new ArrayList<Integer>();
list.add(301);
list.add(302);
list.add(303);

Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
map.put(300, list);

map.get(300); // [301,302,303]