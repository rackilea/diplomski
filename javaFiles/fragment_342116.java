int electionGame = 3;
boolean found = false; //indicates whether user has found right number
while (electionGame > 0 && !found) {
    Scanner sc = new Scanner(System.in);
    int choose = sc.nextInt();
    for (int i = 0; i < caja.length && !found; i++) {
        if (choose == caja[i]) {
            found = true;
        }
    }
    electionGame--;
    if (found) {
        System.out.println("you won");
    } else {
        System.out.println("nope");
    }
}