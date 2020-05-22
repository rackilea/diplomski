List<UserResource> userResources = new ArrayList<>();
userResources.add(new UserResource("John"));
userResources.add(new UserResource("Jane"));
userResources.add(new UserResource("Martin"));
Map<String, List<UserResource>> usersMap = new HashMap<String, List<UserResource>>();
usersMap.put("users", userResources);
ObjectMapper mapper = new ObjectMapper();
System.out.println(mapper.writeValueAsString(usersMap));