Map<String, Set<Integer>> reqdMap = new HashMap<String, Set<Integer>>();

//Form the set corresponding to apple.
Set<Integer> appleSet = new HashSet<Integer>();
appleSet.add(1);
...


reqdMap.put("apple", appleSet);

//To Retrieve
appleSet = reqdMap.get("apple");