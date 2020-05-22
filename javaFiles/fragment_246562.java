import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.DateTimeEntity;
import com.example.entity.LocalDateTimeRep;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalDateTimeDemoApplicationTests {

    @Autowired LocalDateTimeRep repo;

    @Test
    public void contextLoads() {
        DateTimeEntity dateTimeEntity = new DateTimeEntity();
        dateTimeEntity.setLocalDate(LocalDateTime.now());
        DateTimeEntity persistedEntry = repo.save(dateTimeEntity);
        System.out.println(persistedEntry.getLocalDate());
    }

}