while(result.next()) {
        user = new User();  
        user.setId(result.getInt("id"));
        user.setName(result.getString("name"));
        user.setPassword(result.getString("password"));

        list.add(user);

    }