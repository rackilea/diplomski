HashMap<String, String> map = new HashMap<>();

Field entrySetField = HashMap.class.getDeclaredField("entrySet");
entrySetField.setAccessible(true);
Object entrySet = entrySetField.get(map);
System.out.println("entrySet = " + entrySet);
System.out.println("map.toString() = " + map.toString());
entrySet = entrySetField.get(map);
System.out.println("entrySet = " + entrySet);