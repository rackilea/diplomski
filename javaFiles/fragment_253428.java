Session session = null;
        try {
            session = super.getConnection();
            [...]
        } finally {
            closeSession(session);
        }