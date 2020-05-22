ArrayList<String> m = new ArrayList<>();
m.add("a");
m.add("b");
m.add("b");
m.add("c");
m.add("a");
m.add("c");
m.add("a");

for (int i = 0; i < m.size(); i++) {
    for (int j = i + 1; j < m.size(); j++) {
        if (m.get(i).equals(m.get(j))){
            m.set(j, "repeated");
        }
    }
}

System.out.println(m);