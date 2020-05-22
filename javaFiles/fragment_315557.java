public void removeUser(User u){
      while (allUsers.remove(u)) {
        // this loops continue until there are no more entries of user in allUsers (as defined by the User.equals() method)
      }
      // now remove this user from all the remaining user's friends list
      for (User user : allUsers) {
        while (user.getFriends().remove(u)) {
          // remove all occurances
        }
      }
   }