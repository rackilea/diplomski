if (cur.getAmount() >= 10) {
        int num = cur.getAmount() / 10;
        int remainder = cur.getAmount() % 10;
        System.out.println("Dispensing " + num + " 10$ note");
        if (remainder != 0) {
            chain.dispense(new Currency(remainder));
        } else {
            chain.dispense(cur);
        }
    }