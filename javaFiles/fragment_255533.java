@SpringBootApplication
@EnableBinding(Sink.class)
public class So49053074Application {

    public static void main(String[] args) {
        SpringApplication.run(So49053074Application.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void in(byte[] in) {

    }

}