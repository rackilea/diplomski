Scanner sc = new Scanner(System.in);

while (!sc.hasNextInt()) { // <-- 'peeks' at, doesn't remove, the next token
    System.out.println("Please enter a number!");
    sc.next(); // <-- skips over an invalid token
}

return sc.nextInt();