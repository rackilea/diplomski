public String  getCronExp(final Map<String, Object> configMap) {

    LOGGER.debug(">>  getCronExp");

    String exp = "";

    final String type = (String) configMap.get(SCHEDULER_TYPE);
    final String time = (String) configMap.get(TIME);
    final String[] split = time.split(this.COLON);
    String hour = split[0];
    String min = split[1];

    if ("00".equalsIgnoreCase(min)) {
        min = ZERO;
    }
    if ("00".equalsIgnoreCase(hour)) {
        hour = "0";
    }
    if ("daily".equalsIgnoreCase(type)) {

        exp = this.ZERO + this.WHITE_SPACE + min + this.WHITE_SPACE + hour + this.WHITE_SPACE + this.ASTERISK + this.WHITE_SPACE + this.ASTERISK
                + this.WHITE_SPACE + "?";

    } else if ("monthly".equalsIgnoreCase(type)) {
        final String date = (String) configMap.get(START_DATE);
        exp = this.ZERO + this.WHITE_SPACE + min + this.WHITE_SPACE + hour + this.WHITE_SPACE + date + this.WHITE_SPACE + this.ASTERISK + this.WHITE_SPACE
                + "?";

    } else if ("weekly".equalsIgnoreCase(type)) {

        final String dayOfWeek = (String) configMap.get(DAY_OF_WEEK);

        exp = this.ZERO + this.WHITE_SPACE + min + this.WHITE_SPACE + hour + this.WHITE_SPACE + "?" + this.WHITE_SPACE + this.ASTERISK + this.WHITE_SPACE
                + dayOfWeek;
    }

    LOGGER.info("Latest cron  expression scheduler " + exp);
    LOGGER.debug("<<  getCronExp");
    return exp;
}