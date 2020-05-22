traineeCol.setCellValueFactory(new Callback<CellDataFeatures<Trainee>, ObservableValue<Number>>() {
    @Override
    public ObservableValue<Number> call(CellDataFeatures<Trainee> data) {
        Integer value = data.getValue().getTrainingPassed().get(course.getName());
        if (value == null) {
            value = 0 ;
        }
        return new ReadOnlyIntegerWrapper(value);
    }
});