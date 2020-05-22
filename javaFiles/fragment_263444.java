System.out.println("||  CODE   ||    NAME    ||  ALIAS  ||");
        /*select*/
        List<Bank> list = bankBo.listBank();
        for(Bank bank1:list) {
            System.out.println(bank1.toString());
        }