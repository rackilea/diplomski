static String a() { System.out.print("a "); return "0"; }
static String b() { System.out.print("b "); return "1"; }
static int c() { System.out.print("c "); return 2; }
static int d() { System.out.print("d "); return 3; }

public static void main(String... args) {
    System.out.println(a() + b() + c() * d());
}