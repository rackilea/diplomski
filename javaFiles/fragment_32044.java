public void sendMessage(SaveSurveyDTO saveSurvey) {
    SimpleMailMessage message = new SimpleMailMessage();    
    title += "title2";
    message.setSubject(title);
    // templateMessage.setTo(email.toString());
    message.setTo("my@mail.com");
    mailSender.send(message);
}