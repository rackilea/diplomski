cb.getEditor().textProperty().addListener((ov, oldValue, newValue) -> {
    Platform.runLater(() -> {
        filteredList.setPredicate(item -> {
            if (item.startsWith(newValue)) 
                return true; // item starts with newValue
             else 
                return newValue.isEmpty(); // show full list if true; otherwise no match
        });
    });
});