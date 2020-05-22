Stack<String> stack = new Stack<>();
for(int i = 0 ; i < 5 ; i++) {
    // simulating calling gcd recursively
    String s = "Call #" + i + " of gcd";
    stack.push(s);
    System.out.println(s);
}

for (int i = 0 ; i < 5 ; i++) {
    // simulating returning from all the calls to gcd
    System.out.print("Returning from ");
    System.out.println(stack.pop());
}