public class Country {

private static final String PREFERENCES_NAMESPACE = "checkboxes_states";

String code = null;
String name = null;
boolean selected = false;
private SharedPreferences mSettings;
private SharedPreferences.Editor mEditor;

public Country(Context context, String code, String name, boolean selected) {
    super();
    this.code = code;
    this.name = name;
    mSettings = context.getSharedPreferences(PREFERENCES_NAMESPACE, 0);
    mEditor = mSettings.edit();
    setSelected(mSettings.getBoolean(code, selected));
}

public String getCode() {
    return code;
}

public void setCode(String code) {
    this.code = code;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public boolean isSelected() {
    return selected;
}

public void setSelected(boolean selected) {
    if(this.selected != selected) { // update if changed
        mEditor.putBoolean(getCode(), selected);
        mEditor.commit();
        this.selected = selected;
    }
}
}