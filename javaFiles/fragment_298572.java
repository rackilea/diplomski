public static void main(String[] args) {
    PaymentDetailsItem payment = new PaymentDetailsItem("test", "100.00", 10, "1");
    PaymentDetailsItem payment2 = new PaymentDetailsItem("test number 2", "250.00", 10, "2");

    List<PaymentDetailsItem> payments = new ArrayList<>();
    payments.add(payment);
    payments.add(payment2);

    List<String> amounts = payments.stream().map(PaymentDetailsItem::getAmount).collect(Collectors.toList());
    System.out.println("Here we have the extracted List of amounts: " + amounts);

    String totalAmount = amounts.stream()
            .reduce((amount1, amount2) -> String.valueOf(Float.valueOf(amount1) + Float.valueOf(amount2))).get();
    System.out.println("Total amount obtained by using .reduce() upon the List of amounts: " + totalAmount);

    System.out.println("Or you can do everything at once: " + payments.stream().map(PaymentDetailsItem::getAmount)
            .reduce((amount1, amount2) -> String.valueOf(Float.valueOf(amount1) + Float.valueOf(amount2))).get());
}