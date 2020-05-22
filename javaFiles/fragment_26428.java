import java.util.concurrent.Future;
        import org.springframework.scheduling.annotation.Async;
        import org.springframework.scheduling.annotation.AsyncResult;
        import org.springframework.stereotype.Service;
        import org.springframework.web.client.RestTemplate;

        @Service
        public class SampleService {

            @Async
            public Future sendEmail(String email) {
                // here you can place your code for sending email
                return new AsyncResult("email sent successful");
            }

        }