public class InitiateCells extends Region {
    private String name;
    private double width;
    private double height;


    public InitiateCells(String name, double width, double height, int rowIndex, int columnIndex) {
        this.name = name;
        this.width = width;
        this.height = height;

        setPrefSize(width, height);
        getStyleClass().add("board-cell");

        gridBoard.add(this, columnIndex, rowIndex);

    }


    public InitiateCells(String name, double width, double height, int rowIndex, int columnIndex, int value) {
        this(name, width, height, rowIndex, columnIndex);
        pseudoClassStateUpdated(PseudoClass.getPseudoClass("on"), true);
    }

}