Map<Integer, User> userMap = new HashMap<Integer, User>();

User user = new User();
user.setUserId(1);
user.setUsername("user1");
userMap.put(user.getUserId(), user);

user = new User();
user.setUserId(2);
user.setUsername("user2");
userMap.put(user.getUserId(), user);

user = new User();
user.setUserId(3);
user.setUsername("user3");
userMap.put(user.getUserId(), user);