import javafx.beans.property.SimpleStringProperty;

    public class TblQuery {

        private final SimpleStringProperty idProperty = new SimpleStringProperty();
        private final SimpleStringProperty workflowProperty = new SimpleStringProperty();
        private final SimpleStringProperty dateProperty = new SimpleStringProperty();

        public TblQuery(String id, String workflow, String date) {
            this.idProperty.set(id);
            this.workflowProperty.set(workflow);
            this.dateProperty.set(date);
        }

        public void setId(String id) {
            this.idProperty.set(id);
        }

        public String getId() {
            return idProperty.get();
        }

        public String getWorkflow() {
            return workflowProperty.get();
        }

        public void setWorkflow(String workflow) {
            this.workflowProperty.set(workflow);
        }

        public String getDate() {
            return dateProperty.get();
        }

        public void setDate(String date) {
            this.dateProperty.set(date);
        }
    }