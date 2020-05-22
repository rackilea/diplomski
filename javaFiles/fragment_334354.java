private void showDialog() {
    if (canShow) {
        location = myButton.getLocationOnScreen();
        int x = location.x;
        int y = location.y;
        dialog.setLocation(x - 466, y - 514);
        if (!(dialog.isVisible())) {
            Runnable doRun = new Runnable() {

                @Override
                public void run() {
                    dialog.setVisible(true);
                    //setFocusButton();
                    //another method that moving Focus to the desired JComponent
                }
            };
            SwingUtilities.invokeLater(doRun);
        }
    }
}