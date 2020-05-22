void dateSorting(List<Date> dateList, Date newDate) {

    for (int i = 0; i < dateList.size(); i++) {
        if (newDate.before(dateList.get(i))) {
            if (i != 0)
                System.out.println("Previous index:" + (i - 1));
            System.out.println("Next index:" + i);
            break;
        } else if (i == dateList.size() - 1) {
            System.out.println("Previous index:" + i);
        }
    }
}