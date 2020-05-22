//...
logger.info(".... Fetching books");
logger.info("foo --> {}", bookRepository.getByIsbn("foo"));
logger.info("bar --> {}", bookRepository.getByIsbn("bar"));
logger.info("foo --> {}", bookRepository.getByIsbn("foo"));
logger.info("bar --> {}", bookRepository.getByIsbn("bar"));
logger.info("foo --> {}", bookRepository.getByIsbn("foo"));
logger.info("foo --> {}", bookRepository.getByIsbn("foo"));
//...