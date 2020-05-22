class A {

    public void login() {

        Preferences prefs = Preferences.userNodeForPackage(com.mycompany.MyClass.class);

        prefs.putInt("userId", 11);
        ...
    }
}

class B {

    public void insert() {

        Preferences prefs = Preferences.userNodeForPackage(com.mycompany.MyClass.class);

        int userId = prefs.getInt("userId", 0); // 0 is default identifier
        ...
    }
}