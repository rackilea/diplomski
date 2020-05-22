LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
loggingInInterceptor.setPrettyLogging(true);
LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
loggingOutInterceptor.setPrettyLogging(true);
factory.getInInterceptors().add(loggingInInterceptor);
factory.getOutInterceptors().add(loggingOutInterceptor);