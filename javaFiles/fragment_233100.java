@RequestMapping(value = "/banks", method = RequestMethod.GET)
public APIResponseEntity<List<Bank>> getBanks(WebRequest pWebRequest) {

    IUser user = getUser(pWebRequest);
    BankCriteria criteria = new BankCriteria();
    List<Bank> banks= _bankService.getBanks(user, criteria);
    APIResponse<List<Bank>> response = new APIResponse<>(banks);
    APIResponseEntity<List<Bank>> entity =  new APIResponseEntity<List<Bank>>(HttpStatus.OK, response); // errror , cannot infer type arguments for APIResponseEntity
    return entity;
}