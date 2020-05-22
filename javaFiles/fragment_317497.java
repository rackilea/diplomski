Scanner reader = new Scanner(System.in);
double gallons, liters;
int op;
System.out.println("Do you want liters or gallons? Enter a 10 for gallons to liters, and anything else for liters to gallons.");

 op = reader.nextInt();

if (op==10){

        System.out.println("Enter an amount of gallons --> ");
        gallons = reader.nextDouble();
        liters = gallons * 3.785;
        // "%.2f" means that it rounds to 2 dec places. If you change #, that is how many decimal places it rounds to
        System.out.printf("Amount in liters " + "%.2f",liters);
}
 else{


        System.out.println("Enter an amount of liters --> ");
        liters = reader.nextDouble();
        gallons = liters/3.785;
        // "%.2f" means that it rounds to 2 dec places. If you change #, that is how many decimal places it rounds to
        System.out.printf("Amount in gallons (Rounded) " + "%.2f",gallons);
        }
}