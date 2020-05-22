public boolean setReceiver(MessageListener listener) {
        try {
            Properties parm = new Properties();
            parm.setProperty("java.naming.factory.initial",
                    "weblogic.jndi.WLInitialContextFactory");
            parm.setProperty("java.naming.provider.url", URL);
            parm.setProperty("java.naming.security.principal", username);
            parm.setProperty("java.naming.security.credentials", password);
            ctx = new InitialContext(parm);
            final QueueConnectionFactory connectionFactory = (QueueConnectionFactory) ctx
                    .lookup(conFactoryName);
            connection = connectionFactory.createQueueConnection();
            ((WLConnection) connection)
                    .setReconnectPolicy(JMSConstants.RECONNECT_POLICY_ALL);
            ((WLConnection) connection).setReconnectBlockingMillis(30000L);
            ((WLConnection) connection).setTotalReconnectPeriodMillis(-1L);
            session = connection.createQueueSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            queue = (Queue) ctx.lookup(queueName);
            consumer = session.createConsumer(queue);
            consumer.setMessageListener(listener);

            connection.setExceptionListener(new ExceptionListener() {
                @Override
                public void onException(JMSException arg0) {
                    // Assume Disconnected.
                    Logger log2 = new MyLogger().getLogger("BPEL Client");
                    if (arg0 instanceof LostServerException) {
                        log2.severe("Connection to the Server has been lost, will retry in 30 seconds. "
                                + arg0.toString());
                    } else {
                        log2.severe(arg0.toString());
                    }

                }
            });
            connection.start();
            log.info("Successfully connected to " + URL);
            return true;
        } catch (JMSException je) {
            log.severe("Could not connect to the WebLogic Server, will retry in 30 seconds. "
                    + je.getMessage());
            try {
                Thread.sleep(30000L);
            } catch (InterruptedException e) {
                log.warning(e.toString());
            }
            return setReceiver(listener);
        } catch (Exception e) {
            log.severe("Could not connect to the WebLogic Server, will retry in 30 seconds. "
                    + e.toString());
            try {
                Thread.sleep(30000L);
            } catch (InterruptedException ie) {
                log.warning(ie.toString());
            }
            return setReceiver(listener);

        }
    }