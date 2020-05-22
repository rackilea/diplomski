EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        DataModel model = new AddByOneDataModel(0);
        AddViewPane view = new AddViewPane();
        DefaultAddController controller = new DefaultAddController(view, model);

        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // This is where having a getComponent method in
        // view interface would be helpful      
        frame.add(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
});