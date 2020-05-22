public static void main(String[] args) {
            double total = 5000;
            double payWith = 10000;
            double change = 5000;
            Locale locale = new Locale("EN", "US");
            NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
            System.out.println("-----------------------------------------");
            System.out.println("TOTAL:\t\t\t" + formatAlignToRight(formatter.format(total)));
            System.out.println("PAY WITH:\t\t" + formatAlignToRight(formatter.format(payWith)));
            System.out.println("CHANGE:\t\t\t" + formatAlignToRight(formatter.format(change)));
            System.out.println("-----------------------------------------");
            System.out.println("      Thank you, have a good day...!!");
            System.out.println("=========================================");
        }