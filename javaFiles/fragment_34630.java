public class Setting {

    private String name;
    private String description;
    private String[] values;
    private Spinner spinner;

    public Setting(String name, String description, String[] values) {
        this.name = name;
        this.description = description;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getValues() {
        return values;
    }

    public void setSpinner(Spinner s) {
        spinner = s;
    }

    public Spinner getSpinner() {
        return spinner;
    }
}