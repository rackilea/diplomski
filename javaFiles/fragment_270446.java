private static Pattern yes = Pattern.compile(".*\\byes\\b.*");
private static Pattern no = Pattern.compile(".*\\bno\\b.*");
/**
 * @param args
 */
public static void main(String[] args) {
    TestMethod("yes"); //Yes
    TestMethod("no"); //No
    TestMethod("yesterday"); //Bad
    TestMethod("fred-no-bob"); //No
    TestMethod("fred'no'bob"); //No
    TestMethod("fred no bob"); //No
    TestMethod("snow"); //Bad
    TestMethod("I said yes"); //Yes
    TestMethod("yes no"); //Bad
    TestMethod("no yes"); //Bad
}

private static void TestMethod(String input) {
    System.out.print("Testing '" + input + "': ");
    bool matchesYes = yes.matcher(input).matches();
    bool matchesNo = no.matcher(input).matches();

    if (matchesYes == matchesNo) {
        System.out.println("Bad");
    } else if (matchesYes) {
        System.out.println("Yes");
    } else {
        System.out.println("No");
    }
}