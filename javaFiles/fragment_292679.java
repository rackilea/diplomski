double acidPopsTotal(int i) {
    if (i == 1) {
        try {
            return (5.95* (Integer.parseInt(acidPopsTF.getText())));
        } catch (NumberFormatException e) {
            //Missing return - compile error
        }
    } else {
        try {
            return Integer.parseInt(acidPopsTF.getText());
        } catch (NumberFormatException e) {
            //Missing return - compile error
        }
    }
}