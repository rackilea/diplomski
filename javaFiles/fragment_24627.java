ArrayList list = new ArrayList();
for(int i=0;i<setA.length;i++){
    list.add(setA[i]);
}
for(int i=0;i<setB.length;i++){
    list.add(setB[i]);
}
HashSet h = new HashSet();
h.addAll(list);
list.clear();
list .addAll(h);
System.out.println(list);