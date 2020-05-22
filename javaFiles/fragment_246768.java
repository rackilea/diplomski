ExecutorService exec = ... ;
ComboBox<MyDataType> comboBox = new ComboBox<>();
comboBox.setCellFactory(listView -> {

    ListCell<MyDataType> cell = new ListCell<MyDataType>() ;

    ImageView imageView = new ImageView();
    ObjectProperty<Task<Image>> loadingTask = new SimpleObjectProperty<>();

    cell.emptyProperty().addListener((obs, wasEmpty, isNotEmpty) -> {
        if (isNowEmpty) {
            cell.setGraphic(null);
            cell.setText(null);
        } else {
            cell.setGraphic(imageView);
        }
    });

    cell.itemProperty().addListener((obs, oldItem, newItem) ->  {
        if (loadingTask.get() != null && 
            loadingTask.get().getState() != Worker.State.SUCCEEDED &&
            loadingTask.get().getState() != Worker.State.FAILED) {

            loadingTask.get().cancel();
        }
        loadingTask.set(null) ;
        if (newItem != null) {
            Task<Image> task = new Task<Image>() {
                @Override
                public Image call() throws Exception {
                    Image image = ... ; // retrieve image for item
                    return image ;
                }
            };
            loadingTask.set(task);
            task.setOnSucceeded(event -> imageView.setImage(task.getValue()));
            exec.submit(task);

            cell.setText(...); // some text from item...
        }
    }); 

    return cell ;
});