System.out.print("Input number of nodes: ");
nodesNum = scan.nextInt();
scan.nextLine(); //this force the reading of the last newline after reading the integer...

...
System.out.println("Pick your choice: \na. Add Node\nb. Delete Node\nc. Insert Node");
final String letterChoice = scan.nextLine();