private void showInterface() {
    try {
        createStartMenu();
    } catch (ParseException ex) {
        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
    }
}