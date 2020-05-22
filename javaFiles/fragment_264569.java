double itemtotalvisible = 0;
String itemselect = "";
do {
    itemselect = sc.nextLine();
    if (itemselect.equalsIgnoreCase(Ia)){
        itemlone = 0 + Piatos;
    }
    else if (itemselect.equalsIgnoreCase(Ib)){
        itemlone = 0 + Vcut;
    }
    itemtotalvisible += itemlone;
}while (!itemselect.equalsIgnoreCase("end"));

System.out.println("Total" + itemtotalvisible);