public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("How many euros is one dollar?");
        double exchangerate = input.nextDouble();
        //You have to put this in order to continue
        input.nextLine();
        System.out.println("Dollar value (Q to quit):");
        String dollarvalue = input.nextLine();
        double dv = 0.0;
        String bvalue = "";
        String bvaluetwo = "Q";
        if (dollarvalue == bvalue)
        {
            dollarvalue = "test";
        }
        else if ((dollarvalue != bvaluetwo))
        {   
            dv = Double.parseDouble(dollarvalue);
        } 

        Currency exchange = new Currency(exchangerate);

        while (!dollarvalue.equals("Q"))
        {
            double eurovalue = exchange.convert(dv);
            System.out.println(dv + " dollar = " + eurovalue + " euro");
            System.out.println("Dollar value (Q to quit):");
            dollarvalue = input.nextLine();
             if (!dollarvalue.equals("Q")) {     
             dv = Double.parseDouble(dollarvalue);
             eurovalue = exchange.convert(dv);
                System.out.println(dv + " dollar = " + eurovalue + " euro");
            } 

        }
        System.out.println("You pressed Q, have a nice day");
    }
}