public static void main(String[] args) throws Exception {
    for (Currency currency : Currency.values()) {
        System.out.println("Name: " + currency.getName());
        System.out.println("Unit: " + currency.getUnit());
        System.out.println("Country: " + currency.getCountry());
        System.out.println("Rate: " + currency.getRate());
        System.out.println("Change: " + currency.getChange());
        System.out.println("");
    }
}