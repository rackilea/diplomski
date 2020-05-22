private CustomController customController; //= new CustomController();

public void setCustomController(CustomController customController) {
    this.customController = customController;
}

// required for fxmlloader to identify the type
public CustomController getCustomController() {
    return customController;
}