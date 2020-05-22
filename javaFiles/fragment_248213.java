@SpringBootApplication
@EnableCaching
public class So47580936Application {

    public static void main(String[] args) {
        SpringApplication.run(So47580936Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(Bar bar) {
        return args -> {
            bar.cacheFromHere();
            bar.dontCacheFromHere();
        };
    }

    @Component
    public static class Foo {

        @Cacheable(cacheNames = "foos", condition = "T(com.example.So47580936Application$Bar).cacheit()")
        public String foo() {
            System.out.println("here");
            return "foo";
        }

    }

    @Component
    public static class Bar {

        private static final ThreadLocal<Boolean> cacheit = new ThreadLocal<>();

        @Autowired
        private Foo foo;

        public static boolean cacheit() {
            return cacheit.get() == null ? false : cacheit.get();
        }

        public void cacheFromHere() {
            try {
                this.cacheit.set(true);
                System.out.println("Cache:" + this.foo.foo());
                System.out.println("Cache:" + this.foo.foo());
            }
            finally {
                this.cacheit.remove();
            }
        }

        public void dontCacheFromHere() {
            System.out.println("Don't:" + this.foo.foo());
            System.out.println("Don't:" + this.foo.foo());
        }

    }

}