String str = "abc |PARTNER_NAME-PAN xyz";

Pattern patter = Pattern
        .compile("(\\|Term Loan-amount|\\|Bill Purchase / Discounting \\(Inland\\)-amount|\\|PARTNER_NAME-PAN)");
Matcher matcher = patter.matcher(str);

if (matcher.find()) {
    System.out.println("accept");
    System.out.println(matcher.group());
}