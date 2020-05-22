//Will not persist in database 
@Transient
private int ibanSenderId;

Account account = //fetch using tranfer.getIbanSenderId() from database

transfer.setAccount(account);

transferService.save(transfer);