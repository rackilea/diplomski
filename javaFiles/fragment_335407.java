if (newRv.isOk()) {
        String nameReserving = nameReservingTxt.getText();
        String checkIn = dateInTxt.getText();
        int daysStaying = Integer.parseInt(daysStayingTxt.getText());
        String checkOutOn = checkOutOnTxt.getText();
        int siteNumber = Integer.parseInt(siteNumberTxt.getText());
        int power = Integer.parseInt(powerTxt.getText());
        RV rv = new RV (nameReserving, checkIn, daysStaying, checkOutOn, siteNumber, power);
        model.add(rv);
    }