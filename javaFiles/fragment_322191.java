private static void prepareContext() {
        logger.debug("Loading Context");
        try {
        Properties prop = new Properties();
        prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        prop.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        prop.put(Context.PROVIDER_URL, "jnp://10.1.4.48:1099");
        ictx = new InitialContext(prop);
        conFactory = (ConnectionFactory)ictx.lookup("/ConnectionFactory");
        qcon  = (QueueConnection)conFactory.createConnection();
        qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        }
        catch (NamingException er) {
          logger.fatal("Error ", er);
        }
        catch (JMSException er) {
            logger.fatal("Error ", er);
        }
    }



public static boolean sendToQueue(String xml, String sendQ) {
        logger.warn("Sending to queue: " + xml);
        try {
            prepareContext();
            Queue queue =  getQueue(sendQ);
            if (null == queue) {
                throw new JMSException("Queue not defined at the end point");
            }
            qcon.start();
            QueueSender qsender = qsession.createSender(queue);
            TextMessage tmsg = qsession.createTextMessage();
            tmsg.setText(xml);
            qsender.send(tmsg);
            return true;
        }
        catch (JMSException er) {
            logger.fatal("Error ", er);
        }
        finally {
           try { qsession.close(); } catch (Exception er) {/**/}
            try { qcon.close(); } catch (Exception er) {/**/}
        }
        return false;
    }