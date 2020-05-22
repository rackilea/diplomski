public static void main(final String args[]) {

    final InitThread init = new InitThread();
    SwingUtilities.invokeLater(init);

    System.out.println("Session: " + init.getLfForSystemOut().getSession());

}