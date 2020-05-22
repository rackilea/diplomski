final Thread mainThread = Thread.currentThread();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    logger.info("Shut down detected. Setting isRunning to false.");

                    if(processors != null && !processors.isEmpty()){
                        for (Iterator<IProcessor> iterator = processors.iterator(); iterator.hasNext();) {
                            IProcessor iProcessor = (IProcessor) iterator.next();
                            iProcessor.setIsRunning(false);
                            try {
                                iProcessor.closeConnection();
                            } catch (SQLException e1) {
                                logger.error("Error closing connection",e1);
                            }
                        }
                    }
                    try {
                        mainThread.join();
                    } catch (InterruptedException e) {
                        logger.error("Error while joining mainthread to shutdown hook",e);
                    }
                }
            });