public void setMailServerProperties() {

    String emailPort = "587";//gmail's smtp port

    emailProperties = System.getProperties();
    emailProperties.put("mail.smtp.port", emailPort);
    emailProperties.put("mail.smtp.auth", "true");
    emailProperties.put("mail.smtp.starttls.enable", "true");
    emailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // add here

}