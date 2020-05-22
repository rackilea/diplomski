Calendar start = Calendar.getInstance();
start.set(2015, Calendar.DECEMBER, 25);
start.set(Calendar.DAY_OF_MONTH, Calendar.getInstance()
                .getActualMinimum(Calendar.DAY_OF_MONTH));
Calendar end = Calendar.getInstance();
end.setTime(start.getTime());
end.set(Calendar.DAY_OF_MONTH,
                Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
end.add(Calendar.DATE, 7);

Calendar now = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM yyyy");

for (Date dt = start.getTime(); !start.after(end); start.add(
                Calendar.DATE, 1), dt = start.getTime()) {

    System.out.println(sdf.format(dt));
}