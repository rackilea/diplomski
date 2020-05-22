public class Increment {
    int a = 0;
    int increment() {
        return a + 1; 
        // or: return this.a + 1;
        // or: a++; return a; if you want a to be incremented from now on
    }

    public static void main(String[] args) {
        Increment inc = new Increment();
        System.out.println(inc.increment());
    }
}