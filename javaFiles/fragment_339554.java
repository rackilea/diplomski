String[] testCases = {
        "064Y", "064", "64", "0Y", "0"
};
int[] expectedResults = {
        64, 64, 64, 0, 0
};
//                           ┌ optional leading 0
//                           | ┌ 1 or 2 digits from 0 to 9 (00->99)
//                           | | in group 1
//                           | |           ┌ optional one Y
//                           | |           |    ┌ case insensitive
Pattern p = Pattern.compile("0*([0-9]{1,2})Y?", Pattern.CASE_INSENSITIVE);
// fine-tune the Pattern for centenarians 
// (up to 199 years in this ugly draft): 
// "0*([0-1][0-9]{1,2}";
for (int i = 0; i < testCases.length; i++) {
    Matcher m = p.matcher(testCases[i]);
    if (m.find()) {
        System.out.printf("Found: %s%n", m.group());
        int result = Integer.parseInt(m.group(1));
        System.out.printf("Expected result is: %d, actual result is: %d", expectedResults[i], result);
        System.out.printf("... matched? %b%n", result == expectedResults[i]);
    }
}