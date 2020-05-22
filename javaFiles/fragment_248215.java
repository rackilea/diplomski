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

    @Bean
    public ThreadLocal<Boolean> cacheit() {
        return new ThreadLocal<>();
    }

    @Component
    public static class Foo {

        @Cacheable(cacheNames = "foos", condition = "@cacheit.get() ?: false")
        public String foo() {
            System.out.println("here");
            return "foo";
        }

    }

    @Component
    public static class Bar {

        @Autowired
        private ThreadLocal<Boolean> cacheit;

        @Autowired
        private Foo foo;

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