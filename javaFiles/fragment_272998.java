String[][] pbArray = {
        { "August 16th, 2014", "August 13th, 2014", "August 9th, 2014" },
        { "07, 08, 17, 48, 69, 09, $50,000,000",
                "08, 37, 39, 40, 52, 24," + " $40,000,000",
                "03, 12, 31, 34, 51, 24, 90,000,000" } };
// 1.
System.out.println(Arrays.deepToString(pbArray));
// or 2.
for (String [] arr : pbArray) {
    System.out.println(Arrays.toString(arr));
}