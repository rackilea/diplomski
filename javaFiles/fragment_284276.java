int m = (weekday - 1 - col) % 7; // weekday as Calendar-constant (Calendar.SUNDAY etc)
if (m < 0) {
  m += 7;
  row++;
}
col = (col + m) % 7;