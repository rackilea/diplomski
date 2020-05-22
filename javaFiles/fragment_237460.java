@RequestMethod(value = "/accounts/new", method = RequestMethod.POST)
public String postAccount(@ModelAttribute @Valid Account account, BindingResult result) {
    if (result.hasErrors()) {
        return "accounts/accountForm";
    }

    accountDao.save(account);
}