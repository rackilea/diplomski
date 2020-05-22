do {
    ans = input.next().charAt(0);
    if (ans != 'y' && ans != 'n') {
        System.out.println ("Input must be either 'y' or 'n'");
    }
} while (ans != 'y' && ans != 'n');