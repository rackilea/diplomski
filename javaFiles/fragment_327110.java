Facebook meFacebook = new Facebook();
Facebook myFriendFacebook = new Facebook();

meFacebook.addFriend(myFriendFacebook);

Session session = sessionFactory.openSession();
session.beginTransaction();

session.save(myFriendFacebook);
session.save(meFacebook);

session.getTransaction().commit();
session.close();