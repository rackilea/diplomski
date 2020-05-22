public class Test {

    private static String selectedValue = null;
    private static JList jList = new JList();

    public static void main(String args[]) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new GridLayout(4, 1));

        jList = new JList(new String[]{"1", "2", "3", "4", "5"});
        jFrame.add(jList);

        JButton rearrangeButton = new JButton("rearrange");
        rearrangeButton.addActionListener(new Test().new SelectedListener());
        jFrame.add(rearrangeButton);

        JButton addButton = new JButton("add");
        addButton.addActionListener(new Test().new SelectedListener());
        jFrame.add(addButton);

        JButton deleteButton = new JButton("delete");
        deleteButton.addActionListener(new Test().new SelectedListener());
        jFrame.add(deleteButton);

        jFrame.setVisible(true);
    }

    private class SelectedListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            storeSelected();

            if (actionEvent.getActionCommand().equalsIgnoreCase("rearrange")) {
                jList.setListData(new String[]{"5", "4", "3", "2", "1"});
            } else if (actionEvent.getActionCommand().equalsIgnoreCase("add")) {
                List< String> items = new ArrayList< String>();

                for (int item = 0; item < jList.getModel().getSize(); item++) {
                    items.add(jList.getModel().getElementAt(item).toString());
                }

                items.add("new");

                jList.setListData(items.toArray());
            } else if (actionEvent.getActionCommand().equalsIgnoreCase("delete")) {
                List< String> items = new ArrayList< String>();

                for (int item = 0; item < jList.getModel().getSize(); item++) {
                    items.add(jList.getModel().getElementAt(item).toString());
                }

                items.remove(0);

                jList.setListData(items.toArray());
            }

            reSelect();
        }
    }

    private static void storeSelected() {
        if (jList.getSelectedIndex() > -1) {
            selectedValue = jList.getSelectedValue().toString();
        } else {
            selectedValue = null;
        }
    }

    private static void reSelect() {
        if (selectedValue != null) {
            jList.setSelectedValue(selectedValue, true);
        }
    }
}