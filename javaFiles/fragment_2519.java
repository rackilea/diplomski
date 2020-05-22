@RequestMapping(value = "/wallets/{id}", method = RequestMethod.GET)
public ResponseEntity<WalletInfoWrapper > getWalletById(@PathVariable("id") long id) {

    System.out.println("Get wallet info with Id = " + id);

    WalletInfo walletInfo = walletService.getWalletInfo(id);

    if (walletInfo == null) {
        return new ResponseEntity<WalletInfo>(HttpStatus.NOT_FOUND);
    }
   WalletInfoWrapper walletInfoWrapper = new WalletInfoWrapper ();
walletInfoWrapper.setName(walletInfo.getName());
walletInfoWrapper.setAddress(walletInfo.getAddress());
    return new ResponseEntity<WalletInfoWrapper >(walletInfoWrapper , HttpStatus.OK);
}