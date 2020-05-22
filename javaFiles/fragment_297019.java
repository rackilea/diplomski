public class PanelShower extends JFrame {

    Map<JCheckBox, JPanel> boxPanelMap = new HashMap<>();
    final int size = 5;

    public PanelShower() {

        JPanel boxesPanel = new JPanel();
        boxesPanel.setLayout(new BoxLayout(boxesPanel, BoxLayout.PAGE_AXIS));

        JPanel panelsPanel = new JPanel();
        panelsPanel.setLayout(new BoxLayout(panelsPanel, BoxLayout.PAGE_AXIS));

        for (int i = 0; i < size; i++) {
            JCheckBox checkBox = new JCheckBox("Box " + i);
            checkBox.addItemListener(new SelectionListener());
            boxesPanel.add(checkBox);

            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(200, 75));
            panel.setBackground(new Color( (int) (Math.random() * (Math.pow(2, 24) - 1) ) ));
            panel.add(new JLabel("Panel " + i));
            panel.setVisible(false);
            panelsPanel.add(panel);

            boxPanelMap.put(checkBox, panel);
        }

        getContentPane().add(boxesPanel, BorderLayout.LINE_START);
        getContentPane().add(panelsPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class SelectionListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            (boxPanelMap.get(e.getSource())).setVisible(e.getStateChange() == ItemEvent.SELECTED);
            pack();
        }
    }

    public static void main(String args[]) {

        new PanelShower();
    }
}