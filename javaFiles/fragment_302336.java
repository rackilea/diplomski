public class TalendCollectionImporter implements SpigotImporter {

        private ContainerLoader container;
        private Report report;
        private ProgressTicket progressTicket;
        private boolean cancel = false;

        public boolean execute(ContainerLoader loader) {
            this.container = loader;
            this.report = new Report();

            // import stuff

            return !cancel;
        }

        public ContainerLoader getContainer() {
            return container;
        }

        public Report getReport() {
            return report;
        }

        public boolean cancel() {
            cancel = true;
            return true;
        }

}