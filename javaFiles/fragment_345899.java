public static void main(String[] args) {
    int result = JOptionPane.showConfirmDialog(null, "Play again?", "HINT", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.NO_OPTION) {
        System.out.println("No chosen");
    }

    if (result == JOptionPane.YES_OPTION) {
        System.out.println("Picked YES");
    }
}