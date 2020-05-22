public static void main(String args[]) {
    //Add your Scanner code here, your variables, etc
    do {
        showMenu();
        choice = scan.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter temperature: ");
                fahrenheit = scan.nextInt();
                System.out.println(fahrenheit + " Fahrenheit is " + Celsius(fahrenheit) + " Celsius");
                break;
            case 2:
                //Do the same for method 1 but for Celsius
    } while (choice != 3);
}