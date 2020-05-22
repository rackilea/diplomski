Scanner scanner = new Scanner(System.in);
int choice = 0;
while (scanner.hasNext()){
    if (scanner.hasNextInt()){
        choice = scanner.nextInt();
        break;
    } else {
        scanner.next(); // Just discard this, not interested...
    }
}