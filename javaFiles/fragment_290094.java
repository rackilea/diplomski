public AccountActivationEvent extends ApplicationEvent {
    private Account account;

    AccountActivationEvent(Account account) {
       this.account = account;
    }

    public Account getActivatedAccount() {
       return account;
    }
}

public AccountServiceImpl implements AccountService, ApplicationEventPublisherAware
{
 private AccountDAO dao;
 private ApplicationEventPublisher epublisher;

 public void setApplicationEventPublisher(ApplicationEventPublisher epublisher) {
    this.epublisher = epublisher;
 }

 public void activateAccount(AccountID accountID)
 {
  Account account = dao.findAccount(accountID);
  ....
  account.activate();
  dao.updateAccount(account);
  ....

  epublisher.publishEvent(new AccountActivationEvent(account));
 }

}