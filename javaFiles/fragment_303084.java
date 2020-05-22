public static String inputName(Scanner scanner){
    String cubeName;
    System.out.println("Enter the name: ");
    cubeName = scanner.nextLine();
    return cubeName;
}

public static double inputLength(Scanner scanner){
    double cubeLength;
    System.out.println("Enter the length: ");
    cubeLength = scanner.nextDouble();
    return cubeLength;
}    

...

System.out.println("Enter the amount of objects you want to create");
Scanner objNumInput = new Scanner(System.in);
int objNum = objNumInput.nextInt();
//objNumInput.close(); <-- Do not close the scanner
Cube cubes[] = new Cube[objNum];

for (int i = 0; i < objNum; i++){
    String cubeName = Cube.inputName(objNumInput);
    double cubeLength = Cube.inputLength(objNumInput);
    cubes[i] = new Cube(cubeName, cubeLength);
}