public class TestCode2_Scrollbar {

    public static void main(String[] args) {

        JFrame window = new JFrame("Test");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 200);
        window.setMinimumSize(new Dimension(350, 150));

        JPanel panelMain = new JPanel(new BorderLayout());
        window.add(panelMain);

        //Comment the next 2 lines when using without scroll bar

        GridBagLayout innerLayout = new GridBagLayout();
        GridBagConstraints innerConstraints = new GridBagConstraints();
        JPanel innerPanel = new JPanel(innerLayout);
        innerPanel.setBackground(new Color(0, 220, 250));

        //Comment one of the 2 following lines:
        //panelMain.add(innerPanel, BorderLayout.CENTER);

        innerConstraints.weightx = 0.0;
        innerConstraints.weighty = 0.0;
        innerConstraints.gridy = 0;

        innerConstraints.gridx = 0;
        JLabel lblTitle = new JLabel("Title / ");
        innerLayout.setConstraints(lblTitle, innerConstraints);
        innerPanel.add(lblTitle);

        innerConstraints.gridx = 1;
        JLabel lblRating = new JLabel("Rating / ");
        innerLayout.setConstraints(lblRating, innerConstraints);
        innerPanel.add(lblRating);

        innerConstraints.gridx = 2;
        JLabel lblCategoryCode = new JLabel("Category code / ");
        innerLayout.setConstraints(lblCategoryCode, innerConstraints);
        innerPanel.add(lblCategoryCode);

        innerConstraints.gridx = 3;
        innerConstraints.weightx = 1.0;
        innerConstraints.fill = GridBagConstraints.HORIZONTAL;
        JLabel lblDescription = new JLabel("Description");
        innerLayout.setConstraints(lblDescription, innerConstraints);
        innerPanel.add(lblDescription);

        int max = 4;

        for(int i = 0; i < max; i++) {

            innerConstraints.weightx = 0.0;
            innerConstraints.fill = GridBagConstraints.NONE;
            innerConstraints.anchor = GridBagConstraints.NORTHWEST;
            innerConstraints.gridy = i + 1;

            innerConstraints.gridx = 0;
            lblTitle = new JLabel("" + i);
            innerLayout.setConstraints(lblTitle, innerConstraints);
            innerPanel.add(lblTitle);

            innerConstraints.gridx = 1;
            lblRating = new JLabel("" + i);
            innerLayout.setConstraints(lblRating, innerConstraints);
            innerPanel.add(lblRating);

            innerConstraints.gridx = 2;
            lblCategoryCode = new JLabel("" + i);
            innerLayout.setConstraints(lblCategoryCode, innerConstraints);
            innerPanel.add(lblCategoryCode);

            innerConstraints.gridx = 3;
            innerConstraints.weightx = 1.0;
            innerConstraints.fill = GridBagConstraints.HORIZONTAL;
            lblDescription = new JLabel("" + i);
            innerLayout.setConstraints(lblDescription, innerConstraints);
            innerPanel.add(lblDescription);

        }

        innerConstraints.gridy = max + 1;

        JPanel innerVoidPanel = new JPanel();
        innerVoidPanel.setBackground(new Color(0, 250, 250));
        innerConstraints.weighty = 1.0;
        innerConstraints.fill = GridBagConstraints.VERTICAL;
        innerLayout.setConstraints(innerVoidPanel, innerConstraints);
        innerPanel.add(innerVoidPanel);

        //...

        JScrollPane scrollPanel = new JScrollPane(innerPanel);
        panelMain.add(scrollPanel, BorderLayout.CENTER);

        window.setVisible(true);
    }

}