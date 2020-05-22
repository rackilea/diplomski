int[][] matrix = {
    { 1, 2, 3 },
    { 4, 5, 6 },
    { 7, 8, 9 }
};


Object[] array = {
    "1",
    new String[]{
        "2", "3", "4"
    },
    new int[][] {
        { 5 },
        { 6, 7 },
        { 8, 9, 10 }
    }
};


String literal = "literal";

System.out.println(size(matrix));
System.out.println(size(array));
System.out.println(size(literal));