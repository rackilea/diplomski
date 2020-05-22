public class MyEntity {

    private final DoubleProperty money = new SimpleDoubleProperty();
    public DoubleProperty moneyProperty() {
        return money ;
    }
    public final double getMoney() {
        return moneyProperty().get();
    }
    public final void setMoney(double money) {
        moneyProperty().set(money);
    }

    private final ReadOnlyIntegerWrapper moneyState = new ReadOnlyIntegerWrapper();

    public ReadOnlyIntegerProperty moneyStateProperty() {
        return moneyState.getReadOnlyProperty();
    }
    public int getMoneyState() {
        return moneyStateProperty().get();
    }

    private IntegerBinding moneyStateBinding ;

    public MyEntity(double money) {
        setMoney(money) ;
        moneyStateBinding = Bindings.createIntegerBinding(() -> {
            if (getMoney() > 0) {
                return 1 ;
            } else if (getMoney() == 0) {
                return 0 ;
            } else {
                return -1 ;
            }
        }, moneyProperty());

        moneyState.bind(moneyStateBinding);
    }
}