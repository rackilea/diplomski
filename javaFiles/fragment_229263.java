private class FilterDateCell extends DateCell {

        private ObjectProperty<LocalDate> date;
        private BiPredicate<LocalDate, LocalDate> filterPredicate;

        private FilterDateCell(
                ObjectProperty<LocalDate> date,
                BiPredicate<LocalDate, LocalDate> filterPredicate) {
            this.date = date;
            this.filterFunction = filterFunction;
        }

        @Override
        public void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);
            if (filterPredicate.test(item, date.get())) {
                this.setDisable(true);
                setStyle("-fx-background-color: #7e7e7e;"); // I used a different coloring to see which are disabled.
            }
        }

    }