public static void main(String[] args) {
    char[] A = "HR".toCharArray();
    char[] B = "RRR".toCharArray();

    Set<Character> set = new TreeSet<>();
    boolean flag = false;
    for(char c : A) {
        set.add(c);
    }
    for(char c : B) {
        if(set.contains(c)) {
            System.out.println(true);
            flag = true;
            break;
        }
    }
    if(!flag) {
        System.out.println(false);
    }
}