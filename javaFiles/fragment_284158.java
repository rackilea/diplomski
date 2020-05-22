class Class1 extends JComponent {

    @Override
    public void paintComponent(Graphics b) {
        super.paintComponent(b);
        ...    
    }

}

class Class2 extends JComponent {

    @Override
    public void paintComponent(Graphics c) {
        super.paintComponent(c);
        ...    
    }

}


public static void heyo() {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            JFrame window = new JFrame();

            JPanel panel = new JPanel(new GridLayout(1, 2));
            Class1 obj1 = new Class1();
            Class2 obj2 = new Class2();
            panel.add(obj1);
            panel.add(obj2);
            ...

            window.getContentPane().add(panel);
            window.setVisible(true);
        }
    });
}