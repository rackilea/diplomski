public static void main(String[] args) {    
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            FileExtractorGUI gui = new FileExtractorGUI();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(gui);
            frame.pack();
            frame.setVisible(true);
        }
    });
}