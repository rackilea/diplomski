String jsonString = "<The json user list you received>";
     ObjectMapper mapper = new ObjectMapper();

    List user =  mapper.readValue(jsonString.getBytes(), List.class);

    Iterator it = user.iterator();

    List<User> userList = new ArrayList<>();

    while(it.hasNext())
    {
        User receivedUser = new User();
        LinkedHashMap receivedMap = (LinkedHashMap)it.next();
        receivedUser.setUserId((Integer)receivedMap.get("userId"));
        receivedUser.setId((Integer)receivedMap.get("id"));
        receivedUser.setTitle((String)receivedMap.get("title"));
        receivedUser.setBody((String)receivedMap.get("body"));
        userList.add(receivedUser);
    }