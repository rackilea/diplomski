class DoctorsPanel extends JPanel {

    private List<List<String>> model;
    JTextArea history;

    public DoctorsPanel() {
        model = new LinkedList<>();
        history = new JTextArea(11, 31);
        setLayout(new GridLayout(1, 1));
        add(history);
    }

    public void setModel(List<List<String>> model) {
        this.model = model;
        setHistory();
    }

    private void setHistory() {
        this.history.setText(getModelData());
    }

    private String getModelData() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID\tFirst\tLast\tCourse\tYear\n");
        for (List<String> input : model) {
            for (String item : input) {
                sb.append(item);
                if (input.indexOf(item) == input.size() - 1) {
                    sb.append("\n");
                } else {
                    sb.append("\t");
                }
            }
        }
        return sb.toString();
    }

}