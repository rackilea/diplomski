List<String> listB = new List<String>();
listB.add("Red");
listB.add("Brown");
listB.add("Green");
for(String s : listB) {
    Integer quantityFoundInA = countMap.get(s);
    System.out.println("String <"+s"> found in list (map) 'A' "+(quantityFoundInA == null ? 0 : quantityFoundInA.intValue())+" times");
}