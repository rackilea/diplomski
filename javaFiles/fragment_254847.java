for (Account account : allAccounts) {
    if (account.id() == 1) {
        System.out.println("yellow");
    }       
    if ("b".equals(account.name())) {
        System.out.println("ice");
    }       
    if ("c".equals(account.description())) {
        System.out.println("green");
    }       
}