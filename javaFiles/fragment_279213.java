public class TestTextArea extends JFrame {

    public TestTextArea() {

        setLayout(new GridBagLayout());

        JTextArea textArea = new JTextArea();
        textArea.setColumns(10);
        textArea.setRows(1);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        add(textArea);

        setSize(200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        textArea.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent ce) {

                System.out.println("I've changed size");

            }

        });

    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TestTextArea();
    }

}