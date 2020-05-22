if (entry_1.equalsIgnoreCase("FENDER")
                    || entry_1.equalsIgnoreCase("MARTIN")
                    || entry_1.equalsIgnoreCase("GIBSON")
                    || entry_1.equalsIgnoreCase("COLLINGS")
                    || entry_1.equalsIgnoreCase("OLSON")
                    || entry_1.equalsIgnoreCase("RYAN") 
                    || entry_1.equalsIgnoreCase("PRS")) 
{
    entry_1 = entry_1.toUpperCase();

    System.out.println(entry_1);
}
else
{
    entry_1 = "ANY";

    System.out.println(entry_1);
}