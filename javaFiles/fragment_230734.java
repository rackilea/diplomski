Transport transport;
try {
    transport = session.getTransport("smtp");
    transport.connect("smtp.gmail.com", username, password);
    transport.close();

    //Authentication success
} catch (AuthenticationException e) {
    System.out.println("Authentication Exception");
     //Authentication failed. Handle this here.
}