public void display()
{
    for(Account account : chaseAccts) {
        System.out.println(account.getAccount() + " " + account.getAccNum());
    }
}