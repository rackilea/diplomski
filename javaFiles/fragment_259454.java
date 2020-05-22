List<DateBean> dateBeans
            = List.of(new DateBean("201901"), new DateBean("201906"));
    YearMonth currentMonth = YearMonth.now(ZoneId.of("Europe/Sofia"));
    for (DateBean bean : dateBeans) {
        if (bean.getMonth().equals(currentMonth)) {
            System.out.println("" + bean.getMonth() + " is current month");
        } else {
            System.out.println("" + bean.getMonth() + " is not current month");
        }
    }