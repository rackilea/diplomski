if (Desktop.isDesktopSupported()) {
    try {
        if (Desktop.getDesktop().isSupported(Desktop.Action.EDIT)) {
            Desktop.getDesktop().edit(new File("Readme.txt"));
        }
        // or...
        if (Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
            Desktop.getDesktop().open(new File("Readme.txt"));
        }
    } catch (IOException exp) {
        exp.printStackTrace();
    }
}