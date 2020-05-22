private void update() {
    User user1 = new User();
    User contact1 = new User();
    userRepo.save(user1);
    userRepo.save(contact1);
    AssocUserUser assoc = new AssocUserUser();
    assoc.setMyself(user1);
    assoc.setContact(contact1);
    assocUserUserRepo.save(assoc);
}