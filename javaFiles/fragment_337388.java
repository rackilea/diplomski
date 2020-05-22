public class TestFrame extends JFrame{
    private int counter = 10;

    public TestFrame(){
        this.setTitle("Labo - TestFrame");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.getContentPane().add(new JButton(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(counter--);
            }
        }));

        this.setVisible(true);
        this.pack();
    }
}