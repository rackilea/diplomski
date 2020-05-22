public class Board1 extends JPanel implements Board {
    public Board1() {
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(new Zone(...), constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(new Zone(...), constraints);
        // You caught the point I think
    }
}