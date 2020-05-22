ArrayList <ArrayList> outer = new ArrayList<ArrayList>();
ArrayList <Integer> inner1 = new ArrayList<Integer>();
ArrayList <Integer> inner2 = new ArrayList<Integer>();

for (int i = 0; i < 10; i++) {
    inner1.add(i);
    inner2.add(i + 10);
}

outer.add(inner1); 
outer.add(inner2);
System.out.println(Arrays.deepToString(outer.toArray()));