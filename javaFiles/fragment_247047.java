int BATCH_SIZE = 1000
conn = DriverManager.getConnection("username","password");
conn.setAutoCommit(false);
Statement stmt = conn.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_UPDATABLE);
int count = 0;

Map<String, String> emails_map = new HashMap(BATCH_SIZE)<String, String>;
for (Map.Entry<String, List<ClassOBj>> entry : testMap
        .entrySet()) {
    String email = get_useremail();
    String const_val = do_magic(); // this is how you are computing some constant
    String body = construct_body();

    count++;
    String SQL = "YOUR UPDATE STATEMENT";
    stmt.executeUpdate(SQL);  
    emails_map.put(email, body); // can create 
    if (count % BATCH_SIZE == 0) {
        //commits all transcations
        conn.commit();
        //bulk send emails sending 
        //http://stackoverflow.com/questions/13287515/how-to-send-bulk-mails-using-javax-mail-api-efficiently-can-we-use-reuse-auth

        bulk_emails_send(emails_map)
    }

}


public void bulk_emails_send(Map<String, String> emails_map) {
    // Get the default Session object through your setting
    Session session = Session.getDefaultInstance(properties);
    Transport t = session.getTransport();
    t.connect();
    try {
        for (String email_id in emails_map) {
            Message m = new MimeMessage(session);
            //add to, from , subject, body
            m.saveChanges();
            t.sendMessage(m, m.getAllRecipients());
        }
    } finally {
        t.close();
    }
}