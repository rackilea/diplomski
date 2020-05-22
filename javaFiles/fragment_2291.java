public static void main(String[] args)
{
    Scanner console = new Scanner(System.in);
    Double loopFor = 0.0;
    Double w, h, kwh, t;
    for (int i = 0;; i++)
    {
        System.out.print("\nEnter what is being asked. You might have to refer to labels on your appliances");
        System.out.print("\nWATTAGE (W): ");
        w = console.nextDouble();
        System.out.print("\nUSAGE (in HOURS): ");
        h = console.nextDouble();
        System.out.print("\nELECTRICITY RATE (kWh): ");
        kwh = console.nextDouble();

        t = (w * h) / 1000 * kwh;

        System.out.print("\nCOST: " + t);
        loopFor += t;

        System.out.print("\nWould you like to continue? YES [y] No [n]");
        String c = console.next();

        if (c.equalsIgnoreCase("n"))
        {
            break;
        }
    }

}