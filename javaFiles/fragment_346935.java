Set<User> users = new HashSet<User>();
// ...

Map<String, List<User>> hits = new HashMap<String, List<User>>(); 

for (User user : users) {
    String key = user.getMachineName() + user.getEmail();
    List<User> list = hits.get(key);
    if (list == null) {
        list = new ArrayList<User>();
        hits.put(key, list);
    }
    list.add(user);
}

// Users are now grouped by their "machine name + email" as a single key

for (Map.Entry<String, List<User>> hit : hits.entrySet()) {
    if (hit.getValue().size() < 2) continue;
    System.out.println("These users share the same email and machine name: " 
        + hit.getValue()); // hit.getValue() is an ArrayList<User>
}