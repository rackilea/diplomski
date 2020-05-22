public abstract class BaseProduct<A extends Account> {
    public abstract A getAccount();
}

class ProductOne extends BaseProduct<TypeOneAccount> {
    FieldOne fieldOne = new FieldOne();
}

class ProductTwo extends BaseProduct<TypeTwoAccount> {
    FieldTwo fieldTwo = new FieldTwo();
}