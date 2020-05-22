Map<String, Object> map = new HashMap<>();
map.put("/users/" + currentUserId + "/name/", "Albert Einstein");
map.put("/users/" + currentUserId + "/score/", 23);
map.put("/user_detail_profile/" + currentUserId + "/claps/", 45);
map.put("/user_detail_profile/" + currentUserId + "/comments/", 8);
fbDbRefRoot.updateChildren(map);