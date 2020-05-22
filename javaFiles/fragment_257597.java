Calendar rightNow = Calendar.getInstance();
for (int i = 1; i <= 31; i++) {

    rightNow.add(Calendar.DATE, -i);
    Date dateToAdd = rightNow.getTime();
    beforeMin.add(dateToAdd);
}