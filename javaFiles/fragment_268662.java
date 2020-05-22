private void read() {
    User me = new User();
    me.setId(1L);
    AssocUserUser assoc = new AssocUserUser();
    assoc.setMyself(me);
    List<AssocUserUser> contacts = assocUserUserRepo.findAll(Example.of(assoc));
    System.out.println(contacts.size());
}