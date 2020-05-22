String[][] matrix = { 
        { "name", "2", "name" }, 
        { "name", "2", "name" },
        { "name", "2", "name" }, 
        { "name", "2", "name" }, 
};

List<Expression> list=new LinkedList<Expression>();
for (int i = 0; i < matrix.length; i++) 
    list.add(new Expression(matrix[i][0], Integer.parseInt(matrix[i][1]), matrix[i][2]));