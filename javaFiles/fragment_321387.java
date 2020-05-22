Set<User> allUsers = new HashSet<User>();

allUsers.addAll(motherMap.keySet());
allUsers.addAll(fatherMap.keySet());
allUsers.addAll(spouseMap.keySet());

for (User u : allUsers) {
    u.setMother(motherMap.get(u));
    u.setFather(fatherMap.get(u));
    u.setSpouse(spouseMap.get(u));
}