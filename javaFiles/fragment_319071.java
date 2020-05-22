try {
        LocalDateTime dateTime = LocalDateTime.parse(LocalDateTime.now().toString());

        String GMTTiming = String.valueOf(dateTime.getHour() * 100);

        _log.info("GMT Time for Country-->" + GMTTiming);

        List<SchedulerRunTimes> schedulerRunTime = SchedulerRunTimesLocalServiceUtil.getSchedulerRunTimeses(-1, -1);

        for (SchedulerRunTimes schedulerRunTimes : schedulerRunTime) {
            String GMTRunTime = schedulerRunTimes.getGMTRunTime();
            _log.info("GMTRunTime-->" + GMTRunTime);

            _log.info("Compairing GMT Timing --------------->"
                    + GMTTiming.trim().equalsIgnoreCase(GMTRunTime.trim()));

            if (GMTTiming.trim().equalsIgnoreCase(GMTRunTime.trim())) {

                PurchasePrice.triggerCountry(schedulerRunTimes);
            } else {

                _log.info("Time is Different and Country Not Found");
            }
        }
        throw new CountryNotFoundException("Time is Different and Country Not Found");
    } catch (CountryNotFoundException e) {

        e.printStackTrace();
    }