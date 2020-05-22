public static void main(String[] args) {

    //Scanner declaration and other stuff
    //...
    System.out.println("Enter price in $ (0.00 to 1000.00)");
    int price1 = scan.nextInt();
    scan.nextLine();
    System.out.println("Enter user rating (0 to 5)");
    int userRating1 = scan.nextInt();
    scan.nextLine();

    System.out.println("Enter price in $ (0.00 to 1000.00)");
    int price2 = scan.nextInt();
    scan.nextLine();
    System.out.println("Enter user rating (0 to 5)");
    int userRating2 = scan.nextInt();
    scan.nextLine();

    // not sure what constructor Camera has
    Camera camera1 = new Camera(....);
    Camera camera2 = new Camera(....);

    int result = compare(camera1, camera2);

    System.out.println("Result is: " + result);

}

// shouldn't this return an int? also camera should be renamed Camera
public static int compare(Camera camOne, Camera camTwo) {
    int value1 = camOne.computeValue();
    int value2 = camTwo.computeValue();
    /*
     * if(camOne.computeValue() == camTwo.computeValue() && userRating1 ==
     * userRating2)
     */

    int result = Integer.compare(value1, value2);

    return result; // 0 for the same, 1 for first one > second, -1 for opposite
}