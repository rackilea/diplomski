public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

    EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    LocalDateTime creationDate0 = LocalDateTime.of(2018, 12, 26, 8, 10, 40, 341340340);
    LocalDateTime creationDate3 = LocalDateTime.of(2018, 12, 26, 8, 10, 40, 343340340);
    LocalDateTime creationDate7 = LocalDateTime.of(2018, 12, 26, 8, 10, 40, 346670340);
    LocalDateTime creationDate10 = LocalDateTime.of(2018, 12, 26, 8, 10, 40, 349670340);
    entityManager.getTransaction().begin();
    final DatesTbl datesTbl0 = entityManager.merge(new DatesTbl(roundNanoSecForDateTime(creationDate0)));
    final DatesTbl datesTbl3 = entityManager.merge(new DatesTbl(roundNanoSecForDateTime(creationDate3)));
    final DatesTbl datesTbl7 = entityManager.merge(new DatesTbl(roundNanoSecForDateTime(creationDate7)));
    final DatesTbl datesTbl10 = entityManager.merge(new DatesTbl(roundNanoSecForDateTime(creationDate10)));
    entityManager.getTransaction().commit();
    System.out.println("test");
}

private static LocalDateTime roundNanoSecForDateTime(LocalDateTime localDateTime) {
    int nanoSec = localDateTime.getNano();
    // The rounding is based on following results on SQL server 2012 express
    // select cast(cast('2018-12-26 08:10:40.3414999' as datetime2) as datetime);
    // 2018-12-26 08:10:40.340
    // select cast(cast('2018-12-26 08:10:40.3415000' as datetime2) as datetime);
    // select cast(cast('2018-12-26 08:10:40.3444999' as datetime2) as datetime);
    // 2018-12-26 08:10:40.343
    // select cast(cast('2018-12-26 08:10:40.3445000' as datetime2) as datetime);
    // select cast(cast('2018-12-26 08:10:40.3484999' as datetime2) as datetime);
    // 2018-12-26 08:10:40.347
    // select cast(cast('2018-12-26 08:10:40.3485000' as datetime2) as datetime);
    // 2018-12-26 08:10:40.350
    int last7DigitOfNano = nanoSec - (nanoSec / 10000000) * 10000000;
    int roundedNanoSec = 0;
    if (last7DigitOfNano < 1500000) {
        roundedNanoSec = nanoSec - last7DigitOfNano;
    } else if (last7DigitOfNano < 4500000) {
        roundedNanoSec = nanoSec - last7DigitOfNano + 3000000;
    } else if (last7DigitOfNano < 8500000) {
        roundedNanoSec = nanoSec - last7DigitOfNano + 7000000;
    } else {
        roundedNanoSec = nanoSec - last7DigitOfNano + 10000000;
    }
    System.out.println("Before Rounding" + nanoSec);
    System.out.println("After Rounding" + roundedNanoSec);
    return localDateTime.withNano(roundedNanoSec);
}