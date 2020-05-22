String input = "Observações da #{loginBean.centralCreditoRole ? 'central de crédito' : 'loja'}";
Pattern pattern = Pattern.compile("(.*?)#.*?\\?\\s*(?:'(.*?)(?<!\\\\)'\\s+:\\s+'(.*?)(?<!\\\\)')?");

Matcher m = pattern.matcher(input);
while (m.find()) {
    System.out.println(m.group(1));
    System.out.println(m.group(2));
    System.out.println(m.group(3));
}