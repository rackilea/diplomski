final boolean result = messageStore.store(message);
   if (result) {
      logger.info("Stored: {}", message.getId());
   } else {
      logger.warn("Unable to store: {}", message.getId());
   }