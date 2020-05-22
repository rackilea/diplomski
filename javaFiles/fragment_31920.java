import org.springframework.context.annotation.Configuration;
import com.tripbru.ms.experiences.ApplicationContextHolder;

@Configuration
public class AppConfig {

    // Static method used to return an instatnce
    public static AppConfig getInstance() {
        return ApplicationContextHolder.getContext().getBean(AppConfig.class);
    }

    // Properties
}