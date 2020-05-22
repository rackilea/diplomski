Scanner key = new Scanner(System.in);

boolean clear;
int in = 0;

do {
    clear = true;

    try {
        in = key.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Invalid");
        clear = false;
        key.next();
    }

} while (clear == false);

String stringIn = Integer.toString(in);
String[] dec = stringIn.split("");

for (int i = 1; i < (dec.length); i++) {
    System.out.print(dec[i] + " ");
}