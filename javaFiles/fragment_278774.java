@Component(id = "accountsPalette", parameters = {
        "label=literal:My palette",
        "selected=selectedAccountsIds",
        "model=availableAccountIdsModel",
        "encoder=accountsEncoder"})
private Palette accountsPalette;

public SelectModel getAvailableAccountIdsModel() throws Exception {

    final List<OptionModel> options = new ArrayList<OptionModel>();

    for(Account account : availableAccounts) {

        options.add(new OptionModelImpl(account.getFullNameSingleType(), account.getId()));
    }

    return new AbstractSelectModel() {

        public List<OptionModel> getOptions() {
            return options;
        }

        public List<OptionGroupModel> getOptionGroups() {
            return null;
        }
    };
}

public ValueEncoder<Long> getAccountsEncoder(){
    return new ValueEncoder<Long>() {

        public String toClient(Long value) {
            return value.toString();
        }

        public Long toValue(String clientValue) {
            return Long.parseLong(clientValue);
        }
    };
}

public List<Long> getSelectedAccountsIds() {
    return selectedAccountIds;
}

public void setSelectedAccountsIds(List<Long> selectedAccountIds) throws Exception {
    ..... deal with the selected ids .....
}