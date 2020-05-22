// create starting user and membergroup    
tx.begin();
User user = new User();
em.persist(user);
GroupMember group = new GroupMember();
em.persist(group);
tx.commit();
em.clear();

// update users for groupId 2
System.out.println("update users for groupId 2");
tx.begin();
List<User> users = new ArrayList<>();
users.add(user);
group.setGroupMemberList(users);
em.merge(group);            
tx.commit();
em.clear();

// update groups for userId 1 -- doesn't work, not owner of relationship
System.out.println("update groups for userId 1 -- doesn't work, not owner of relationship");
tx.begin();
List<GroupMember> groups = new ArrayList<>();
groups.add(group);
user.setGroupList(groups);
em.merge(user);            
tx.commit();
em.clear();

// update groups for userId 1 -- works
System.out.println("update groups for userId 1 -- works");
tx.begin();
for ( GroupMember groupMember: groups) {
    groupMember.getGroupMemberList().add(user);
    em.merge(groupMember);            
}
tx.commit();
em.clear();