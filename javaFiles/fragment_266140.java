@Parameterized.Parameters
    public static Collection testCases() {
        return Arrays.asList(new Integer[][][] {
            {{1,1,1}, {2,2,2}, {3,3,3}},
            {{2,2,2}, {3,3,3}, {4,4,4}}
        });
    }