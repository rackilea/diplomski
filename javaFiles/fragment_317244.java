import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Students myBeanForStudentsInSchool13() {
        Students students = new Students();
        students.setAddress("myBeanForStudentsInSchool13");

        return students;
    }

    @Bean
    public Students myBeanForStudentsInSchool23() {
        Students students = new Students();
        students.setAddress("myBeanForStudentsInSchool23");

        return students;
    }
}