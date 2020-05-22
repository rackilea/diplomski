public static void main(String[] args) {
 System.out.println(SwingUtilities.isEventDispatchThread()); // 1
 SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            System.out.println(SwingUtilities.isEventDispatchThread()); //2
            EBLFWE window = new EBLFWE();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setExtendedState( window.getExtendedState()|JFrame.MAXIMIZED_BOTH );
            window.setSize(1024, 728);
            window.setVisible(true);
        }
    });