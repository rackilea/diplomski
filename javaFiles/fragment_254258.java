User user = new User();
//some setters and getters 
UserPosition userPosition = new UserPosition();
//some setters and getters 

user.addUserPosition(userPosition);
user.setDefaultUserPosition(userPosition);

session.persist(user);