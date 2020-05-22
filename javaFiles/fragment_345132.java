@Bean
public CommandLineRunner demo(Bulk_repositoryRepository repository) {
return (args) -> {          

    Date currentDate = new Date();

    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -2);

    Date dateTwoDaysAgo = cal.getTime();


        // fetch customers by Status
        log.info("Customer found with findByStatus('0'):");
        log.info("--------------------------------------------");
        repository. findAllByStatusAndCampTypeAndCampStartDateBetween(1,2,currentDate,dateTwoDaysAgo).forEach(on -> {
            log.info(on.toString());
        });
    };
}