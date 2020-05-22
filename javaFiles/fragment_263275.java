// Sort the Object Array        
Arrays.sort(arrayPengiriman);

System.out.println("|==============================================================================|");
System.out.println("|                                DATA PENGIRIMAN                               |");
System.out.println("|==============================================================================|");
System.out.println("");

// Displays the Sorted Array   
for (int i = 0; i < 16; i++) {
    System.out.print("  " + (i + 1) + ". " + arrayPengiriman[i].toString());
}