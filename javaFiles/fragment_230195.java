System.out.println("Input name: ");

String scanner1 = sc1.nextLine();

name[i] = scanner1;

boolean done = false;
double weight = 0;
do {
    System.out.println("Input weight: ");
    String input = sc1.nextLine();
    try {
        weight = Double.parseDouble(input);
        done = true;
    } catch (NumberFormatException nfe) {
        System.out.println("!! Invalid value");
    }
} while (!done);
weightkg[i] = weight;

System.out.println("Name: " + name[i]);

System.out.println("weight : " + weightkg[i]);