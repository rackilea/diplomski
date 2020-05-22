public class TimestampEntityListener {
    @PrePersist
    public void setDefaultTime(BaseEntity entity) {
       if(entity.getInsertTime() == null) {
           entity.setInsertTime(new Timestamp((new Date()).getTime())):
       }
    }
}

@MappedSuperclass
@EntityListeners({TimestampEntityListener.class})
public abstract class BaseEntity {...}