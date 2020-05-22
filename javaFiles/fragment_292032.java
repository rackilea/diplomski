int roadsCount = Integer.parseInt(buildingsAndRoadsArray[1]);
Road[] roadsArray = new Road[roadsCount];
for (int i = 0; i < roadsArray.length; i++) {
    System.out.println();
    System.out.println("Road:" + i);
    System.out.print("Enter I J K L: ");
    String input = scan.nextLine();
    String[] inputSplit = input.split(" ");
    Road road = new Road(Integer.parseInt(inputSplit[0]), Integer.parseInt(inputSplit[1]),
            Integer.parseInt(inputSplit[2]), Integer.parseInt(inputSplit[3]));
    roadsArray[i] = road;
}
scan.close();
System.out.println();
for (int i = 0; i < roadsArray.length; i++) {
    System.out.println("Road: " + i + roadsArray[i] + "\n");
}