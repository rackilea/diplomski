int n = 8;

String del;
String del2 = "";

for (int i = 1; i <= n; i++) {
    System.out.print(del2 + "(");
    del = "";
    for (int j = 1; j <= i; j++) {
        System.out.print(del + j);
        del = " + ";
    }
    System.out.print(")");
    del2 = " + ";
}