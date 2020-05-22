public class ListeningFileHandler extends FileHandler {

        public ListeningFileHandler() throws IOException {
            super();
        }

        @Override
        protected synchronized void setOutputStream(OutputStream out) throws SecurityException {
            super.setOutputStream(out);
            if (Level.OFF.equals(super.getLevel())) { //Rotating...
                sendEmailToAdmin();
            }
        }

        private void sendEmailToAdmin() {
            //...
        }
    }