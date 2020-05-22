public void setUsername(String username) {
    editor.putString(TAG_USERNAME,username);
    editor.commit();
}

public String getUsername() {
    return preferences.getString(TAG_USERNAME,"null");
}