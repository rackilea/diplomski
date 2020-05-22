public class FXML2Controller {

    @FXML
    private ComboBox<NamedDuration> comboBox;

    @FXML
    private void comboChange() {
        NamedDuration duration = comboBox.getValue();
        if (duration != null) {
            System.out.format("%d days = %s\n", duration.getDays(), duration.getName());
        }
    }

    @FXML
    private void initialize() {
        // set converter to convert between String and NamedDuration
        comboBox.setConverter(new StringConverter<NamedDuration>() {

            @Override
            public String toString(NamedDuration object) {
                return object == null ? "" : object.getName();
            }

            @Override
            public NamedDuration fromString(String string) {
                if (string == null || string.isEmpty()) {
                    return null;
                }

                // try matching names
                for (NamedDuration nd : comboBox.getItems()) {
                    if (nd.getName().equalsIgnoreCase(string)) {
                        return nd;
                    }
                }

                // try matching number
                int days;
                try {
                    days = Integer.parseInt(string);
                } catch (NumberFormatException ex) {
                    return null;
                }
                for (NamedDuration nd : comboBox.getItems()) {
                    if (days == nd.getDays()) {
                        return nd;
                    }
                }

                return null;
            }

        });
    }

}