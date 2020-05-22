import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

@Named("funBean")
public class FunBean {

        private static final Logger slf4jLogger = LoggerFactory.getLogger(FunBean.class);

         @Scheduled(fixedDelay = 5000)
        public void doSomething() {
            slf4jLogger.info("I am working");
        }

    }