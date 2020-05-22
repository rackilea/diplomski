for (int i = 0; i < 10; i++) {
    LocalDateTime time = LocalDateTime.of(LocalDate.now(), 
            LocalTime.of(random.nextInt(24), random.nextInt(60),
            random.nextInt(60), random.nextInt(999999999 + 1)));
    System.out.println(time);
}