public List<List> getList(List<List<Date>> lists, int num) {
    List<List> result = new ArrayList<List>();
    for (List list : lists) {
        Collections.sort(list);
        if (checkList(list, num)) {
            result.add(list);
        }

    }
    return result;
}

public boolean checkList(List<Date> list, int num) {
    int count = 0;
    for (int i = 0; i < list.size() - 1; i++) {
        Calendar calendar1 = Calendar.getInstance();

        calendar1.setTime(list.get(i));
        calendar1.set(Calendar.DAY_OF_MONTH,calendar1.get(Calendar.DAY_OF_MONTH)+1);
        calendar1.set(Calendar.HOUR_OF_DAY,0);
        calendar1.set(Calendar.MINUTE,0);
        calendar1.set(Calendar.MILLISECOND,0);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(list.get(i + 1));
        calendar2.set(Calendar.HOUR_OF_DAY,0);
        calendar2.set(Calendar.MINUTE,0);
        calendar2.set(Calendar.MILLISECOND,0);

        if (calendar1.equals(calendar2)) {
            count++;
        } else {
            count = 0;
        }
        if (count >= num) {
            return true;
        }
    }
    return false;
}