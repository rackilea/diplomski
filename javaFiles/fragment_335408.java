if (newRv.isOk()) {
        String nameReserving = newRv.getName();
        String checkIn = newRv.getDateIn();

        // .... etc

        RV rv = new RV (nameReserving, checkIn, daysStaying, checkOutOn, siteNumber, power);
        model.add(rv);
    }