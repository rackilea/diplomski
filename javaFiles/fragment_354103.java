for (FileItem item : items) {
    if (item.isFormField()) {
      logger.log(Level.INFO, "Received form field:");
      logger.log(Level.INFO, "Name: " + item.getFieldName());
      logger.log(Level.INFO, "Value: " + item.getString());
    } else {
      logger.log(Level.INFO, "Received file:");
      logger.log(Level.INFO, "Name: " + item.getName());
      logger.log(Level.INFO, "Size: " + item.getSize());
    }