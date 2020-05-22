public static void main(String[] args) {
    GUI view = new GUI(); // created your own instance
    Controller controller = new Controller(view); // gave controller that instance

    // Launches JavaFX which starts the life-cycle documented above
    Application.launch(view.getClass(), args);
}