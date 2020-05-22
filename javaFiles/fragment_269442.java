List<Object[]> results = this.em.createNativeQuery("SELECT a.id, a.firstName, a.lastName, a.version FROM Author a").getResultList();

    results.stream().forEach((record) -> {
            Long id = ((BigInteger) record[0]).longValue();
            String firstName = (String) record[1];
            String lastName = (String) record[2];
            Integer version = (Integer) record[3];
    });