public void setIndicatorVisible() {
    System.out.println("\n\nCHECK ACTIVITY INDICATOR ON\n\n");
    synchronized(lblActivityIndicator) {
         lblActivityIndicator.setVisible(true);
    }
}


public void setIndicatorInvisible() {
    System.out.println("\n\nCHECK ACTIVITY INDICATOR OFF\n\n");
    synchronized(lblActivityIndicator) {
        lblActivityIndicator.setVisible(false);
    }
}