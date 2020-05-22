for (User u : users) {
    usersWithPhone.put(u.id, new UserWithPhone(u));
}
for (Phone p : phones) {
    usersWithPhone.get(p.id).setPhoneDetails(p);
}