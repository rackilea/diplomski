if(b.containsKey("createBundle")) {
        token = b.getString("sessionID");
        name = b.getString("nameID");
  } else if(b.containsKey("logInBundle")) {
       token = b.getString("loginToken");
       name = b.getString("loginName");
  }