CustomList<A1> customList = new CustomList<A1>();
customList.add(new A1());

for (A1 obj: customList) {
    System.out.println(obj.getCustomBoolean());
}