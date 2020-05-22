int[] nums = { 1, 2, 3 };

System.out.println(nums);
// [I@xxxxx

System.out.println(Arrays.toString(nums));
// [1, 2, 3]

int[][] table = {
        { 1, },
        { 2, 3, },
        { 4, 5, 6, },
};

System.out.println(Arrays.toString(table));
// [[I@xxxxx, [I@yyyyy, [I@zzzzz]

System.out.println(Arrays.deepToString(table));
// [[1], [2, 3], [4, 5, 6]]