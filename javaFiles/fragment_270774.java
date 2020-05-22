for (Person p : persons) {
        String username = p.getUsername();
        User user = map.get(username);
        if (user != null) {
           System.out.println(user.getEmail());
        } else {
          System.out.println("User " + username + " is unknown");
        }
    }