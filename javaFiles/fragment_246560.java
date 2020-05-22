import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DateTimeEntity
{
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime localDate;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public LocalDateTime getLocalDate()
    {
        return localDate;
    }

    public void setLocalDate(LocalDateTime localDate)
    {
        this.localDate = localDate;
    }

}