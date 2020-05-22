public static void main(String[] args) {
    try {
        Desktop desktop = Desktop.getDesktop();
        if (desktop.isSupported(Desktop.Action.OPEN)) {
            desktop.open(new File("Your.pdf"));
        } else {
            System.out.println("Open is not supported");
        }
    } catch (IOException exp) {
        exp.printStackTrace();
    }
}