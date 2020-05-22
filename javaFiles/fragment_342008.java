public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            System.out.println("Here I start");

            // note that the use of invokeLater twice is not necessary
            SwingUtilities.invokeLater(() -> new SwingWorkerExample().displayGUI());

            // there is nothing in the code that pauses or delays this line of code
            System.out.println("I'll show up when the SwingWorkerExample has finnished");
        }
    });
}