Scanner input = new Scanner(System.in);
System.out.println("Enter number of shipments");
String noOfShipments = input.nextLine();
//NumberUtils class is from apache commons
if(!NumberUtils.isNumber(noOfShipments)) {
    throw new IllegalArgumentException("The number of shipments is supposed to be an integer");
}
int shipmentNo = Integer.parseInt(noOfShipments);
for(int i=0;i<shipmentNo;i++) {
    System.out.println("Enter shipment details for shipment no "+(i+1));
    String shipmentDetail = input.nextLine();  // Read shipment details
    //Do something with this input and keep parsing until the end of the for loop
}