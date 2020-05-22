private List<JTextField[]> fields = new ArrayList<>(3);

//....

class SpinerListener implements ChangeListener {

    public void stateChanged(ChangeEvent arg0) {
        vertices = slider.getValue();

        if (vertices < fields.size()) {
            List<JTextField[]> oldFields = fields.subList(vertices + 1, fields.size());
            for (JTextField[] pairs : oldFields) {
                for (JTextField field : pairs) {
                    right.remove(field);
                }
            }
            fields.removeAll(oldFields);
            right.revalidate();
            right.repaint();
        } else if (vertices > fields.size()) {
            int count = (vertices - fields.size());
            System.out.println("Add " + count + " new fields");
            for (int index = 0; index < count; index++) {
                JTextField[] pairs = new JTextField[2];
                pairs[0] = new JTextField(4);
                pairs[1] = new JTextField(4);

                for (JTextField field : pairs) {
                    right.add(field);
                }

                fields.add(pairs);
            }
            right.revalidate();
            right.repaint();
        }
    }

}