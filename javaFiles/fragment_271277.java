public class TimestampEntityListener {
        @Autowired
        EntityManager entityManager;

        @PrePersist
        public void setDefaultTime(BaseEntity entity) {
           AutowireHelper.autowire(this, this.entityManager);
           if(entity.getInsertTime() == null) {
               Timestamp timestamp = (Timestamp)entityManager.createNativeQuery("select clock_timestamp()").getSingleResult();
               entity.setInsertTime(timestamp):
           }
        }
    }