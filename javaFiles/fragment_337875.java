public class Visual {

GridBagConstraints gbc = new GridBagConstraints();
JPanel panel = new JPanel(new GridBagLayout());

JTextField[][] box = new JTextField[9][9];

public Visual() {

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            box[i][j] = new JTextField("0", 3);
            gbc.gridx = i;
            gbc.gridy = j;
            panel.add(box[i][j]);
        }
    }
}