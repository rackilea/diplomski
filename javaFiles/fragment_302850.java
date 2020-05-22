@SpringBootApplication
@EnableTransactionManagement
public class So47793485Application {

    public static void main(String[] args) {
        SpringApplication.run(So47793485Application.class, args);
    }

    @Component
    public static class Foo {

        @Transactional
        public void foo() {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {

                @Override
                public void afterCommit() {
                    System.out.println("here");
                }

                @Override
                public void afterCompletion(int status) {
                    System.out.println(
                            status == TransactionSynchronization.STATUS_COMMITTED ? "committed" : "rolled back");
                }

            });
        }

    }

}