public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hello from Java main!");
        NativeCppAdapter adapter = new NativeCppAdapter();
        adapter.locLoadLib();
        adapter.testKickoffSoForPrint();
    }
}