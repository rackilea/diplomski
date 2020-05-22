String firstRow = "Left Leg Time(ms): 676589";
String secondRow = "Gyroscope : -1.20 , -1.38 , -3.05";

String[] firstRowParts = firstRow.split(" ");
int time = Integer.parseInt(firstRowParts[3]);   // 676589
String[] secondRowParts = secondRow.split(" ");
int x = Integer.parseInt(secondRowParts[2]);     // -1.20
int y = Integer.parseInt(secondRowParts[4]);     // -1.38
int z = Integer.parseInt(secondRowParts[6]);     // -3.05