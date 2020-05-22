boolean done = false;
   while(count>0){
        for (UUID user : usersClient.getUserUUIDList()){
            try{
                LOG.info("USER STATUS for user {}",user.getId().toString());
                Optional<ExternalUserStatus> userStatus=adminClientFactory.newUssClient().getStatusForUser(orgId,Constants.IMP_ENTITLEMENT,user.getId().toString());
                System.out.println(userStatus.toString());
                done = (userStatus.isPresent() && (userStatus.get().getState()=="activated"))
            }
            catch(Exception ex){
                LOG.info("Exception caught while getting userStatus");
            }
        });
        count--;
        if (done) break;
        Thread.sleep(1000*60*1);
    }