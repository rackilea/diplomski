final User user;
        if(users.containsKey(id)) {
            user = users.get(id);
        }
        else {
            user = new User(id);
            users.put(id, user);
        }