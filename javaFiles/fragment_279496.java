public class AccountNameComparator implements Comparator<AccountProfile> {
    private final String query;
    public AccountNameComparator(String query) {
    this.query = query;
    }
    @Override
    public int compare(AccountProfile first, AccountProfile second) {
        Integer f = first.getName().indexOf(this.query);
        Integer s = second.getName().indexOf(this.query);
        return f.compareTo(s);
    }
}