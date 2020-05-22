public static void main(String[] args) {
    Campaign first= new Campaign("test");
    Vote pvote = new Vote("vote1222");
    Vote[] votes = new Vote[] { pvote };
    first.setVotes(votes);
    System.out.println(first.getTitle() + " " + " " + Arrays.toString(first.getvotes()));
}