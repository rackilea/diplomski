OriginateAction originateAction = new OriginateAction();
   originateAction.setChannel("SIP/1001");
   originateAction.setContext("from-internal");
   originateAction.setExten("1002");
   originateAction.setCallerId("Server");
   originateAction.setPriority(1);
   originateAction.setTimeout(30000);

   // connect to Asterisk and log in
   managerConnection.login();
   //send the originate action and wait for a maximum of 30 seconds for Asterisk
   // to send a reply
   ManagerResponse response= managerConnection.sendAction(originateAction, 30000);