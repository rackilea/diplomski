ArrayList<Integer> list1 = new ArrayList<>();
for(int i = 1; i <= 5; i++) {
    list1.add(i);
}
System.out.println("List1 "+list1);
ArrayList<Integer> list2 = new ArrayList<>(list1);
System.out.println("List2 "+list2);
list2.add(6);
System.out.println("List1 Not Changed "+list1);