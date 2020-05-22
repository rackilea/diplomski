System.out.println("Please Enter the Account Name:");
name = kb.nextLine();

System.out.println("Please Enter the Account Number:");
number = kb.nextInt();
kb.nextLine(); //clear the end of line

System.out.println("Please Enter the Account Balance:");
balance = kb.nextDouble();
kb.nextLine(); //clear the end of line

System.out.println("Please Enter the Account Type");
acType = kb.nextLine();

System.out.println();
type = acType.toUpperCase().charAt(0);