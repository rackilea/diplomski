Set<String> userIds = new HashSet<>();
             userIds.add("user1");
             userIds.add("user2");
             userIds.add("user3");

   UserService.getInstance(context).processUserDetails(userIds); //server call

   AppContactService appContactService = new AppContactService(context);
   Contact contact = appContactService.getContactById("user1");
            if(contact != null){
               Log.e("Friend Display Name", contact.getDisplayName());
              }