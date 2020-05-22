tasks.forEach(task -> task.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
    if (isSelected) {
        // . . .
    } else {
        // . . .
    }
}));