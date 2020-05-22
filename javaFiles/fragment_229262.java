public class MinMaxDate {

    private void test() {
        DatePicker firstDP = new DatePicker();
        DatePicker secondDP = new DatePicker();

        // set the min date
        secondDP.setDayCellFactory(cf -> new MinDateCell(firstDP.valueProperty()));
        // set the max date
        secondDP.setDayCellFactory(cf -> new MaxDateCell(firstDP.valueProperty()));
    }

    private class MinDateCell extends DateCell {

        private ObjectProperty<LocalDate> date;

        private MinDateCell(ObjectProperty<LocalDate> date) {
            this.date = date;
        }

        @Override
        public void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);
            if (item.isBefore(date.get())) {
                this.setDisable(true);
                setStyle("-fx-background-color: #7e7e7e;"); // I used a different coloring to see which are disabled.
            }
        }

    }

    private class MaxDateCell extends DateCell {

        private ObjectProperty<LocalDate> date;

        private MaxDateCell(ObjectProperty<LocalDate> date) {
            this.date = date;
        }

        @Override
        public void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);
            if (item.isAfter(date.get())) {
                this.setDisable(true);
                setStyle("-fx-background-color: #7e7e7e;"); // Same here
            }
        }

    }

}