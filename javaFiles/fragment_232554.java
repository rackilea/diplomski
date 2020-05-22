@Test
public void testMailExceptionAlternate() {
    try {
        Mockito.doThrow(Mockito.mock(MailException.class)).when(mailSender).send(Mockito.any(MailMessage.class));
        emailService.notify(messageBody);
    } catch (MailException ex){
        Assert.fail("MailException was supposed to be caught.");
    }
}