private Date lastAlertDate;

    private static final BALANCE_LIMIT = 5000;

    private void handleBalanceUpdated(long balance) {
        if (balance < 5000) {
        log.info("Balance has gone below {}", BALANCE_LIMIT);
        int daysDifference = getDifferenceInDays(lastAlertDate, new Date());
        if (daysDifference >= 1) {
            log.info("Last alert was {} days ago, going to send email alert", daysDifference);
            alertService.sendSimpleAlert("Balance has gone below " + BALANCE_LIMIT + "!");
            lastAlertDate = new Date();
        }
    }
    }