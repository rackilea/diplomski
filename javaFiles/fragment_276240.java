for(int eight = 0; eight < 8; eight++) {

    message = in.readLine();
    LOGGER.fatal(eight);
    LOGGER.fatal(message);

    if(message.contains("Content-Length")) {
        try {
            message.getChars(16, 20, size, 0); THIS LINE                
        } catch (YourException e) {
            // Handle the exception
        }
    }
}