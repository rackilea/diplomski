LocalDate localDate = LocalDate.now();

    LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    Period dayDifference = Period.between(localDate, endLocalDate);

    log.info("Local Current Date " + localDate + " End Local Date " + endLocalDate + " and Day Difference is "
            + dayDifference);