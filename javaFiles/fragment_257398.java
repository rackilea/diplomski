public long uniqueCode() {
      long result = 17;
      result = 31 * result + numero;
      result = 31 * result + Long.MAX_VALUE << 16 + fornitura;
      result = 31 * result + Long.MAX_VALUE << 32 + stringCode(film);
      return result;
  }

  public static long stringCode(String s) {
     if (s == null) return 0;
     long h = 0;
     int len = s.length();
     for (int i = 0; i < len; i++) {
          h = 31*h + s.charAt(i);
     }
     return h;
  }