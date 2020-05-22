entityManager.remove(group)
for (User user : group.users) {
     user.groups.remove(group);
}
...
// then merge() and flush()