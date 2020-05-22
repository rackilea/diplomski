while(true){     
     if(rs.next()){
        String usernameDb = rs.getString("username");
        String passwordDb = rs.getString("password");
        if(usernameInput.equals(usernameDb) && passwordInput.equals(passwordDb)){
            System.out.println("Access Granted..");
            break;
          }

     }

     else{
            System.out.println("Access denied..");
            break;
     }
    }