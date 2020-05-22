public class ListViewCell extends ListCell<SessionExercise> {

    private final SimpleExerciseListItemController listItemController ;

    public ListViewCell() {
        FXMLLoader listItemLoader = new FXMLLoader();
        listItemLoader.setLocation(getClass().
            getResource("/view/SimpleExerciseListItem.fxml"));

        try {
            listItemLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SimpleExerciseListItemController listItemController
                = (SimpleExerciseListItemController) listItemLoader.getController();

        }
        @Override
        public void updateItem(SessionExercise exercise, boolean empty) {
            // don't omit this!!!
            super.updateItem(exercise, empty);

            if (empty) {
                setGraphic(null);
            } else {
                // update controller and ui as necessary

                this.setGraphic(listItemController.getAnchorPane());
            }
        }
}