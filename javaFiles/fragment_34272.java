//Setting up connection
ConnectionConfiguration config = new ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
        connection = new XMPPConnection(config);
        connection.connect();
//login
        connection.login(userName, password);
//get your roster   
    Roster roster = connection.getRoster();
//add a new roster entry aka SEND INVITATION

roster.createEntry(address, name, groups);