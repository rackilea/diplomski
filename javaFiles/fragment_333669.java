@Transactional(rollbackFor = Exception.class)
public WalletInfo create(String name, String currency, String address) {

    // create the WalletInfo entity with provided name and address
    WalletInfo walletInfo = new WalletInfo();
    walletInfo.setAddress(address);
    walletInfo.setName(name);
    walletInfo.setCurrency(currency);

    // persist the created instance into the database
    sessionFactory.getCurrentSession().persist(walletInfo);
    return walletInfo;
}