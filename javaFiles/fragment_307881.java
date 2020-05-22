public class QuestionTableModel extends AbstractTableModel {
    private List<Question> questions;

    public QuestionTableModel(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public int getRowCount() {
        return questions == null ? 0 : questions.size();
    }

    @Override
    public int getColumnCount() {
        return // the number of columns you want to display
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return // The object class appropriate for the column/class property 
                // you want to display
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        if (questions != null) {
            Question question = questions.get(rowIndex);
            // Get the column value from the question
            // based on the columnIndex and the
            // question properties
        }
        return value;
    }


}