final CsvToBean<UserProvisioning> beans = 
    new CsvToBeanBuilder<UserProvisioning>(new FileReader("c:\\test.csv"))
        .withType(UserProvisioning.class)
        .withIgnoreQuotations(true)
        .withThrowExceptions(false) //1
        .build();

    final List<UserProvisioning> users = beans.parse();//2
    users.stream().forEach((user) -> {
        logger.info("Parsed data:" + user.toString());
    });

    beans.getCapturedExceptions().stream().forEach((exception) -> { //3
        logger.error("Inconsistent data:" + 
                      String.join("", exception.getLine()), exception);//4
    });