public static String format(long value) {

      if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
      if (value < 0) return "-" + format(-value);
      if (value < 1000) return Long.toString(value);

      Map.Entry<Long, String> e = suffixes.floorEntry(value);
      Long divideBy = e.getKey();
      String suffix = e.getValue();

      long truncated = value / divideBy;
      double withDecimals = (value*1.0) / divideBy;
      boolean hasDecimal = (withDecimals != Math.floor(withDecimals));
      return !hasDecimal ? truncated + suffix : String.format("%.1f", withDecimals) + suffix; 
  }