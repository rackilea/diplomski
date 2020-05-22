public static void main(String[] args) {
    long timeBefore1 = System.currentTimeMillis();
    Stack<String> s = new Stack<String>();
    for (int i = 0; i < 50000; i++) {
        s.push("Value = " + i);
    }
    long timeAfter1 = System.currentTimeMillis();
    long timeBefore2 = System.currentTimeMillis();
    while (!s.isEmpty()) {
        System.out.println(s.pop());
    }
    long timeAfter2 = System.currentTimeMillis();
    System.out.println("Time spent on building stack (ms): " + (timeAfter1 - timeBefore1));
    System.out.println("Time spent on reading stack (ms): " + (timeAfter2 - timeBefore2));
}