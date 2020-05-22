@AfterClass
public static void printResult() {
    if (!parameterResults.isEmpty()) {
        parameterResults.entrySet().stream().forEach(pR -> {
            System.out.println("\nParameter: " + pR.getKey());
            System.out.println("\tPassed: " + (pR.getValue().getFail() > 0 ? "NO" : "YES"));
            System.out.print("\tTest Cases: " + pR.getValue().getSuccess() + pR.getValue().getFail());
            System.out.print("  Successful: " + pR.getValue().getSuccess());
            System.out.println("  Failed: " + pR.getValue().getFail());
    }
}