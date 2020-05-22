enum Item {
    TREE ('t'),
    FOOD ('f');

    private final char symbol;
    Item(char symbol) {
        this.symbol = symbol;
    }
    char getSymbol() { return symbol; }
}
class MyClass {
    public void printWorld() {
        Item[][] map = new Item[15][12];
        map[0][0] = Item.TREE;
        map[0][1] = Item.FOOD;
        System.out.print(map[0][0].getSymbol());
        System.out.print(map[0][1].getSymbol());
    }
}