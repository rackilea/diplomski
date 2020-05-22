public class Field extends JFrame {

    private Room room = new Room();

    public Field() {

        //Mock panel
        JPanel filler = new JPanel();
        filler.setOpaque(false);

        getContentPane().setBackground(Color.GRAY);
        getContentPane().add(filler, BorderLayout.PAGE_START);
        getContentPane().add(room);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 455));
        setLocationRelativeTo(null);
        pack();
        room.init();
        setVisible(true);
    }
}