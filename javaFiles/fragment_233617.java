private void showInterface() {
    try {
        Interface test = new Interface();
    } catch (ParseException ex) {
        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
    }
}