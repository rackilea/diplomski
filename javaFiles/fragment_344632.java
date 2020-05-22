public static void main(String[] args) {
  BigDecimal half = new BigDecimal("0.5");
  for (int i = 0; i < Integer.MAX_VALUE; i++) {
    float f = i + 0.5f;
    if (new BigDecimal(f).compareTo(new BigDecimal(i).add(half)) != 0) {
      System.out.println(new BigDecimal(i).add(half) + " => " + new BigDecimal(f));
      break;
    }
  }
}