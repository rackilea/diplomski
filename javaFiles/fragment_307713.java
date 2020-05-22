while (true) {
    while (!s.hasNextInt()) s.next();
        amount = s.nextInt();
    if(amount < 0 || amount > numberOfCards) {
        System.out.println("You need to enter a number between 0 and "+numberOfCards);
    } else {
       break;
    }
}