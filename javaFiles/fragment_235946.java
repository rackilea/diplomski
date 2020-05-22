public enum TableType { 

    MULT, 
    ADD;

    public static TableType get(char operand) {
        return (operand == '+') ? ADD : ((operand == '*') ? MULT : null);
    }

    public int result(int x, int y) {
        return (this == ADD) ? (x + y) : (x * y);
    }
}

...

TableType example = TableType.get('*');
System.out.println(example.result(4, 4)); // 16