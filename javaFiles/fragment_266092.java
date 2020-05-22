public ControllerException(final String message, int errorcode) {
    super(message);
    this.errorcode=errorcode;

    Logger logger = Logger.getLogger(ControllerException.class.getName());

    logger.setFilter(new Filter() {
        @Override
        public boolean isLoggable(LogRecord record) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd',' yyyy HH:mm:ss a");
            String fileName = "error.log";

            try {
                PrintWriter outputStream = new PrintWriter(fileName);
                outputStream.println("Time: " + sdf.format(new Date(record.getMillis()))); 
                outputStream.println("Reason: " + message);
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return true;
        }
    });

    logger.info(message);
}