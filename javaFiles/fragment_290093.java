public AccountServiceImpl implements AccountService
{
 private AccountDAO dao;
 private MailSenderService mailSender;

 public void activateAccount(AccountID accountID)
 {
   Account account = dao.findAccount(accountID);
   ....
   account.activate();
   dao.updateAccount(account);
   ....

   mailSender.sendActivationEmail(account);
 }

}