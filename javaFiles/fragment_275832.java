public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            List<String> list = new ArrayList<String>(Arrays.asList(
                "Austria", "Croatia", "Hungary", "Italy"));
            JFrame f = new JFrame("AutoTest");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(new Java2sAutoTextField(list));
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }
    });
}