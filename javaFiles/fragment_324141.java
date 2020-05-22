Map<Integer, Object> map = new HashMap<Integer, Object>();
Integer key = Integer.valueOf(5);
Object test = new Object();
map.put(key, test);
Object test2 = map.get(Integer.valueOf(5));

test.equals(test2); // will be true