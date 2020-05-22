Scanner s1 = new Scanner(System.in);
while (true) {
    String a = s1.nextLine();
    if (a.equals("END")) {
        break;
    }
    str1[count] = a;
    String b = s1.nextLine();
    if (b.equals("END")) {
        break;
    }
    str2[count] = b;
    count++;
    System.out.println("完成第" + count + "个依赖" + "  " + a + "->" + b);
}