IntegerBinding moneyState = Bindings.createIntegerBinding(() -> {
    if (money.get() > 0) {
        return 1 ;
    } else if (money.get() == 0) {
        return 0 ;
    } else {
        return -1 ;
    }
}, money);