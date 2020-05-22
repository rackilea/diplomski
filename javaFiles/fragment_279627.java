public static void main (String args[]) {
    //Java 7 and below
    SwingUtilities.invokeLater(new Runnable() {
        //Your code here
    });

    //Java 8 and higher
    SwingUtilities.invokeLater(() -> {
        //Your code here
    });
}