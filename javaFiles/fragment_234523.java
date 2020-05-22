Scanner input;
input = new Scanner(System.in);
x = input.nextInt();
do {
    y = y + 1;
    if (y == 0){
        System.out.println("Eroare");
    }
    while (x == 0)
        if (y == 0){
            System.out.println("Eroare");
        }
    while (x == 1)
        if (x%y == 0){
            System.out.println (y);
        }
} while (y < x);