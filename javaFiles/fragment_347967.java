private static class Grid {

    public static void outputGrid() {
        IntStream
            .range(0, 10)
            .mapToObj(Grid::generateRow)
            .forEach(System.out::println);
    }

    private static String generateRow(int row) {
        return IntStream
            .range(0, 10)
            .mapToObj(col -> String.format("%d%d", col, row))
            .collect(Collectors.joining(" "));
    }
}

public static void main(String []args){
   Grid.outputGrid();
}