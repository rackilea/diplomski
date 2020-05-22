Scanner sc = new Scanner(System.in);
Stack<String> stack = new Stack<String>() ;
System.out.println("Enter sentence:");

sc = new Scanner(sc.nextLine());

while (sc.hasNext())
    stack.push(sc.next());