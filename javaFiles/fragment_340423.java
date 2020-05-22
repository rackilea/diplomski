SharedPreferences preferences;
public SharedPreferences.Editor editor;

public void setCheckboxes(HashMap<String, boolean> checkboxes) {

    editor.putString("checkbox_1", checkboxes.get("checkbox_1"));
    editor.putString("checkbox_2", checkboxes.get("checkbox_2"));
    editor.putString("checkbox_3", checkboxes.get("checkbox_3"));
    editor.putString("checkbox_4", checkboxes.get("checkbox_4"));
    editor.apply();
}

public HashMap<String, boolean> getCheckboxes() {
    HashMap<String, boolean> checkboxes = new HashMap<String, boolean>();
    checkboxes.put("checkbox_1", preferences.getString("checkbox_1", false));
    checkboxes.put("checkbox_2", preferences.getString("checkbox_2", false));
    checkboxes.put("checkbox_3", preferences.getString("checkbox_3", false));
    checkboxes.put("checkbox_4", preferences.getString("checkbox_4", false));

return checkboxes;

}