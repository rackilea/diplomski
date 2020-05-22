public static void main(String... args) {

    Set<Member> memberSet = new HashSet<Member>();
    for (int i = 0; i < 100; i++)
        memberSet.add(new Member(i));

    List<Member> list = new LinkedList<Member>(memberSet);
    Collections.shuffle(list);
    Set<Member> randomSet = new HashSet<Member>(list.subList(0, 5));

    System.out.println(randomSet);
}

static class Member {
    final int value;
    public Member(int value) {
        this.value = value; 
    }
    @Override
    public String toString() {
        return "" + value;
    }
}