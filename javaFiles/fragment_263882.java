User user =     findUserId(id); //All groups wont be loaded they are marked lazy
     Group group =  findGroupId(id);  //All users wont be loaded they are marked lazy

     UserGroup  userGroup = new UserGroup();
     userGroup.setUser(user);
     userGroup.setGroup(group);

     em.save(userGroup);