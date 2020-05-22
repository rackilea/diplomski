Map<String, Integer> cources = new HashMap<>();
for (Student s : list) {
    //I assumed that eg. "\tCOP2250, ENC3250, COP3530" is in a (public) variable Cources 
    //in your Student class. You can replace this by a getter or whatever you need.
    for (String name : s.Courses.replace("\t", "").split(", ")) {
        if (cources.containsKey(name))
            cources.replace(name, cources.get(name)+1);
        else
            cources.put(name, 1);
    }
}
//some output for testing
cources.forEach((a, b) -> System.out.println(a + " - " + b));