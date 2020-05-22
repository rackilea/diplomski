listView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) ->{
    ObservableList<String> selectedItems = listView.getSelectionModel().getSelectedItems();
    if(selectedItems.contains("Fade Transition"))
    {
        fade.play();
    }
    else
    {
        fade.jumpTo(Duration.ZERO);
        fade.stop();                
    }

    if(selectedItems.contains("Translate Transition"))
    {
        translate.play();
    }
    else
    {
        translate.jumpTo(Duration.ZERO);
        translate.stop();
    }

    if(selectedItems.contains("Scale Transition"))
    {
        scale.play();
    }
    else
    {
        scale.jumpTo(Duration.ZERO);
        scale.stop();
    }            
});