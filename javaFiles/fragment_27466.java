Scanner keyboardIn = new Scanner(System.in);

System.out.println("Enter a date\n(Month Day, Year) or (XX/XX/XXXX):");

String date = keyboardIn.nextLine().replaceAll(",", "");

Scanner dateScanner = new Scanner(date);

String month = dateScanner.next();
int day = dateScanner.nextInt();
int year = dateScanner.nextInt();

System.out.println(month + " " + day + " " + year);