@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class So49957413Application extends GlobalAuthenticationConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(So49957413Application.class, args);
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("foo").password("bar").roles("baz");
    }

    @Autowired
    private Foo foo;


    @RabbitListener(queues = "foo")
    public void listen(Message in) {
        try {
            SecurityContext ctx = SecurityContextHolder.createEmptyContext();
            ctx.setAuthentication(
                new UsernamePasswordAuthenticationToken(in.getMessageProperties().getHeaders().get("user"), "bar"));
            SecurityContextHolder.setContext(ctx);
            this.foo.method1();
            try {
                this.foo.method2();
            }
            catch (AccessDeniedException e) {
                System.out.println("Denied access to method2");
            }
        }
        finally {
            SecurityContextHolder.clearContext();
        }
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }

    public static class Foo {

        @PreAuthorize("hasRole('baz')")
        public void method1() {
            System.out.println("in method1");
        }

        @PreAuthorize("hasRole('qux')")
        public void method2() {
            System.out.println("in method2");
        }

    }
}