@Override
void run(String... args) throws Exception {
    System.exit(SpringApplication.exit(ctx, new ExitCodeGenerator() {
        @Override
        int getExitCode() {
            log.info 'retrieving exit code.'
            return -1
        }
    }))
}