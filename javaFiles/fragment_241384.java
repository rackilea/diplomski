public static BigDecimal round(BigDecimal d, int scale, boolean roundUp) {
  int mode = (roundUp) ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN;
  return d.setScale(scale, mode);
}
round(new BigDecimal("12.390"), 2, true); // => 12.39
round(new BigDecimal("12.391"), 2, true); // => 12.40
round(new BigDecimal("12.391"), 2, false); // => 12.39
round(new BigDecimal("12.399"), 2, false); // => 12.39