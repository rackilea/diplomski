module checker {
    requires javafx.fxml;
    requires javafx.controls;
    requires TextInputProgram;

    opens sample to javafx.fxml;

    exports sample;
}