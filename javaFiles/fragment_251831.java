listOfSteps = FXCollections.observableArrayList(
    new Callback<ActionStep, Observable[]>() {
        @Override
        public Observable[] call(ActionStep actionStep) {
            return new Observable[] { actionStep.nameProperty() } ;
        }
    });
actionStepListView.setItems(listOfSteps);