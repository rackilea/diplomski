Instant ldapEpoch = Instant.parse("1601-01-01T00:00:00Z");
    ZoneId zone = ZoneId.of("America/Port-au-Prince");

    LocalDate date = LocalDate.now(zone);
    Instant startOfDay = date.atStartOfDay(zone).toInstant();
    Duration sinceLdapEpoch = Duration.between(ldapEpoch, startOfDay);
    assert sinceLdapEpoch.getNano() == 0 : sinceLdapEpoch;
    long ldapTimestamp = sinceLdapEpoch.getSeconds() * 10_000_000;
    System.out.println(ldapTimestamp);