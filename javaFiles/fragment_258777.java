public void actionPerformed(ActionEvent arg0) {
    if(isDark == true) {
        lightTheme();
        isDark = false;
    } else {
        darkTheme();
        isDark = true;
    }