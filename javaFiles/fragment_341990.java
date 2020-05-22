static Comparator<Member> MEMBER_ID_COMPARATOR = new Comparator<Member>() {
    @Override
    public int compare(Member first, Member second) {
       assert(first.getId() != null);
       assert(second.getId() != null);
       return first.getId().compareTo(second.getId());
    }   
}