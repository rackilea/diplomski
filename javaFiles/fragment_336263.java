String [] operators = new String [3];
operators[0] ="!";
operators[1] ="&&";
operators[2] ="||";
String command;

Scanner sc = new Scanner(System.in);        
System.out.println("Command: ");

do {
    command = sc.next();
} while(!command.equals(operators[0]) || !command.equals(operators[1]) || !command.equals(operators[2]));