Random random = new Random();
List<Key> keyList = new ArrayList<Key>();
keyList.addAll (map.keySet());
int index = random.nextInt(keyList.size());
key = keyList.get (index);
keyList.remove (index); // this ensures eniqueness by removing the used keys
value = map.get(key);