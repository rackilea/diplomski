c = [1,2,3];

Map<Int, String> data = new HashMap();
data.put(1, "One");
data.put(2, "Two");
data.put(3, "Three");

ArrayList<String> output = new ArrayList()
for(int i=0 i<c.length; i++) {
    output.add(data.get(c[i]));
}