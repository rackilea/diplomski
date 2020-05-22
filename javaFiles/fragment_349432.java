import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class StdinProducerExample implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Flux
        .create(sink -> {
          Scanner scanner = new Scanner(System.in);
          while (scanner.hasNext()) {
            sink.next(scanner.nextLine());
          }
        })
        .subscribeOn(Schedulers.newSingle("stdin publisher"))
        .subscribe(m -> log.info("User message: {}", m));
    log.info("Started listening stdin");
  }

}