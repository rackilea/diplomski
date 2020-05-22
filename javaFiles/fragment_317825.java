public static void main(String[] args) throws Exception {
    EventQueue.invokeLater(new Runnable() {

        public void run() {
            JFrame f = new JFrame("GraphPanel");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel(new BorderLayout());
            JButton button = new JButton("Button");
            panel.add(button, BorderLayout.PAGE_START);
            Selection gp = new Selection(); 
            panel.add(gp, BorderLayout.CENTER);
            f.add(new JScrollPane(panel), BorderLayout.CENTER);                
            f.pack();
            f.setVisible(true);
        }
    });
}