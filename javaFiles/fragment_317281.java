DBAdapter db = new DBAdapter(this);
Cursor c = null;

try {
    db.open();
    c = db.GetOption(c, "theme");
    String theme = c.getString(1);
    if (theme.equalsIgnoreCase("dark")) {
        THEME = R.style.Theme_Sherlock;
    }
    else if (theme.equalsIgnoreCase("light")) {
        THEME = R.style.Theme_Sherlock_Light;
    }
    else if (theme.equalsIgnoreCase("darklight")) {
        THEME = R.style.Theme_Sherlock_Light_DarkActionBar;
    }
}
catch (Exception ex) {}
finally {
    try {
            if (c != null)
            {
                c.close();
                c = null;
            }
        }
        catch (Exception ex){}
        db.close();
}
setTheme(THEME);