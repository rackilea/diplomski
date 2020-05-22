StringBuilder sb = new StringBuilder("'");
int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
for(int co=0; co <= maxDay; co++) {
    c.add(Calendar.DATE, 1);
    sb.append(ft.format(c.getTime())).append("','");
}
if (sb.length() > 1) {
    sb.setLength(sb.length() - 2);
    incDate = sb.toString();
}