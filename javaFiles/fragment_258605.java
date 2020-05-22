public class CircleCell extends TableCell<Person, String> {

    @Override
    protected void updateItem(String item, boolean empty) {

        super.updateItem(item, empty);

        if (isSafe(item, empty)) {
            CellData data = CellData.cellData(item);
            Circle circle = new Circle(6);
            circle.setFill(data.getColor());
            setGraphic(circle);
        }
    }

    private boolean isSafe(String item, boolean empty) {
        return !empty && Objects.nonNull(item);
    }
}