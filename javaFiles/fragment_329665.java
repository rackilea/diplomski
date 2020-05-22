public static void main(String[] args) {
    // TODO Auto-generated method stub


    Set<Integer> s = new HashSet<Integer>();
    s.add(1);
    s.add(2);
    s.add(3);

    permutations(s, new Stack<Integer>(), s.size());
}