public class ReplicationInsertEventListener 
        implements PostInsertEventListener {

    public static final ReplicationInsertEventListener INSTANCE = 
        new ReplicationInsertEventListener();

    @Override
    public void onPostInsert(
            PostInsertEvent event) 
            throws HibernateException {
        final Object entity = event.getEntity();

        if(entity instanceof Post) {
            Post post = (Post) entity;

            event.getSession().createNativeQuery(
                "INSERT INTO old_post (id, title, version) " +
                "VALUES (:id, :title, :version)")
            .setParameter("id", post.getId())
            .setParameter("title", post.getTitle())
            .setParameter("version", post.getVersion())
            .setFlushMode(FlushMode.MANUAL)
            .executeUpdate();
        }
    }

    @Override
    public boolean requiresPostCommitHanding(
            EntityPersister persister) {
        return false;
    }
}

public class ReplicationUpdateEventListener 
    implements PostUpdateEventListener {

    public static final ReplicationUpdateEventListener INSTANCE = 
        new ReplicationUpdateEventListener();

    @Override
    public void onPostUpdate(
            PostUpdateEvent event) {
        final Object entity = event.getEntity();

        if(entity instanceof Post) {
            Post post = (Post) entity;

            event.getSession().createNativeQuery(
                "UPDATE old_post " +
                "SET title = :title, version = :version " +
                "WHERE id = :id")
            .setParameter("id", post.getId())
            .setParameter("title", post.getTitle())
            .setParameter("version", post.getVersion())
            .setFlushMode(FlushMode.MANUAL)
            .executeUpdate();
        }
    }

    @Override
    public boolean requiresPostCommitHanding(
            EntityPersister persister) {
        return false;
    }
}

public class ReplicationDeleteEventListener 
        implements PreDeleteEventListener {

    public static final ReplicationDeleteEventListener INSTANCE = 
        new ReplicationDeleteEventListener();

    @Override
    public boolean onPreDelete(
            PreDeleteEvent event) {
        final Object entity = event.getEntity();

        if(entity instanceof Post) {
            Post post = (Post) entity;

            event.getSession().createNativeQuery(
                "DELETE FROM old_post " +
                "WHERE id = :id")
            .setParameter("id", post.getId())
            .setFlushMode(FlushMode.MANUAL)
            .executeUpdate();
        }

        return false;
    }
}