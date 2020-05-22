Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();

        Event event = new Event();
        session.save(event);

        Message testMessage = new Message();
        testMessage.setEvent(event);
        event.setMessages(new HashSet<Message>());  //the list was not initialized.
        event.getMessages().add(testMessage);
        session.save(event);
        tx.commit();

    } catch (Exception e) {
        e.printStackTrace();
        tx.rollback();


    } finally {
        session.close();
    }