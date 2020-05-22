Contacts myContacts = new Contacts();
String[] contactList = null;
try {
    contactList = myContacts.getContacts();//gets all my contacts
} 
catch (IOException ex) {
    Logger.getLogger(Calls.class.getName()).log(Level.SEVERE, null, ex);
}

CallFactory callFactory = client.getAccount().getCallFactory();

for (String contact : contactList) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("Url", "http://demo.twilio.com/docs/voice.xml"));
    params.add(new BasicNameValuePair("To", contact));
    params.add(new BasicNameValuePair("From", "YOUR_TWILIO_NUMBER"));
    params.add(new BasicNameValuePair("Method", "GET"));

    Call call = null;
    try {
        call = callFactory.create(params);
    } catch (TwilioRestException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}