@Test
public void testMailException() throws MailException {

    Mockito.doThrow(Mockito.mock(MailException.class)).when(mailSender).send(Mockito.any(MailMessage.class));
    emailService.notify(messageBody);

}