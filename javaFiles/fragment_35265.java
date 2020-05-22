package hello;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

    @Configuration
    @ConfigurationProperties(prefix="job", locations = "classpath:cronjob.yml")
    public class CronConfig {

        private List<String> schedules;

        @Bean
        public List<String> schedules() {
            return this.schedules;
        }

        public List<String> getSchedules() {
            return schedules;
        }

        public void setSchedules(List<String> schedules) {
            this.schedules = schedules;
        }
    }