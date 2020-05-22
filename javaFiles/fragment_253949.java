ArrayList<Character> set = new ArrayList<>();
set.add('a');
set.add('b');
set.add('c');

for(ArrayList<Character> element : getPermutations(set,2)) {
    System.out.println(element);
}
System.out.println("----------");
for(ArrayList<Character> element : getPermutations(set,3)) {
    System.out.println(element);
}
System.out.println("----------");

set.add('d');

for(ArrayList<Character> element : getPermutations(set,2)) {
    System.out.println(element);
}
System.out.println("----------");
for(ArrayList<Character> element : getPermutations(set,3)) {
    System.out.println(element);
}