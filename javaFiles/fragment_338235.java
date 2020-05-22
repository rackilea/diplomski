Scanner status = new Scanner(System.in);
String maritalStatus = status.nextLine();

do {
    System.out.println("Enter your marital status.")
    switch (maritalStatus) {
        case "s": 
            // your code here
            break;
        case "m":
            // your code here
            break;
        default:
            // here you specify what happens when maritalStatus is not "s" or "m"
            System.out.println("Try again.");
            break;
        }
    // loop while maritalStatus is not equal to "s" or "m"
    } while (!("s".equalsIgnoreCase(maritalStatus)) && 
             !("m".equalsIgnoreCase(maritalStatus)));