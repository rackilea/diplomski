public enum AccountType {
    Checking {
        @Override
        public String acctType() { return "Checking Account"; }
    },
    Savings {
        @Override
        public String acctType() { return "Saving Account"; }
    },
    CreditCard {
        @Override
        public String acctType() { return "Credit Card Account"; }
    };

    public abstract String acctType();
}