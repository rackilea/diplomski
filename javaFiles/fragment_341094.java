public boolean authenticateSMTP( SMTPConfiguration smtpConfiguration ) throws MessagingException {
    try {
        Properties properties = new Properties(  );
        properties.put( "mail.smtp.auth", true );
        properties.put( "mail.smtp.host", "smtp.gmail.com" );
        properties.put( "mail.smtp.port", 465 );
        properties.put( "mail.smtp.ssl.enable", true);

        Transport transport = Session.getInstance( properties ).getTransport();
        transport.connect( getSmtpUsername(), getSmtpPassword() );
        transport.close();
        return true;
    } catch ( AuthenticationFailedException e ) {
        return false;
    }
}