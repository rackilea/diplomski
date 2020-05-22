Map<String, String> map = (TreeMap<String, String>) snapshot.child("firstName").getValue();
for (Map.Entry<String, String> entry : map.entrySet()) {
    if (entry.getValue().equals("Lovelace")) {
        System.out.println("first name exists");
    } else {
        System.out.println("does not exist");
    }
}