@Entity

@NamedQueries ( value = {
    @NamedQuery (
        name = pagedDeleteExpiredItems
        query=    DELETE FROM MyTable
            WHERE (<table key>) IN (
                SELECT <table key> FROM (
                SELECT ROWNUM AS row_num, <table key> FROM MyTable
                WHERE timestamp <= :currentTime
                )
                WHERE row_num < :pageSize
            )
    )
})

public class MyEntity {
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    int doPagedDeleteExpiredItems(Date currentTime, int pageSize) {
        Query query = em.createNamedQuery("pagedDeleteExpiredItems");
        query.setParameter("currentTime", currentTime);
        query.setParameter("pageSize", pageSize);
        int deleteCount = query.executeUpdate();
        return deleteCount;
    }
}


@EJBTimer
public class DeleteExpiredItemsTimer {

    @EJB(beanName = "MyEntity")
    MyEntity myEntity;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    void handleTimeout(Timer timer) {
        Date currentTime = getCurrentTime()
        int pageSize = 100
        int deleteCount;
        do {
            myEntity.doPagedDeleteExpiredItems(currentTime, pageSize);
        } while(deleteCount>0);
    }
}