System.out.println("Enter commands U(up),D(down),L(left),R(right)");
String command = scan.next();

for (char directionCommand : command.toCharArray()){
    move(directionCommand);
}