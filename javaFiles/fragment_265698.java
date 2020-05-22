@Configuration
@EnableAsync
public class Example {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Example.class);
        System.out.println(ctx.getBean(HttpClientImpl.class).getClass());
    }
}

interface HttpClient {
    void doGetAsync();
}

@Component
class HttpClientImpl implements HttpClient {
    @Async
    public void doGetAsync() {
        System.out.println(Thread.currentThread());
    }
}