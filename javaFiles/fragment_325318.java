NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.FRANCE);

String france = "1 599,99 €";
String format = currencyInstance.format(1599.99);
Number number = currencyInstance.parse(format);


System.out.println("France: " + format);
System.out.println("Format: " + format);
System.out.println("Number: " + number);

if(france.equals(format)) {
    number = currencyInstance.parse(france); // Must work;
    System.out.println(number);
} else {

    char[] fr = france.toCharArray();
    char[] ft = format.toCharArray();

    for(int i = 0; i < fr.length; i++) {
        if(fr[i] != ft[i]) {
            System.out.printf("The value on position %d are not equal. France: %d; Format: %d", i,(int)fr[i], (int)ft[i]);
        }
    }

}