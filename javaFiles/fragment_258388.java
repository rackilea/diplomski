package test;

import java.util.HashMap;
import java.util.Map;

public class Test {

      Map<String, StringBuilder> map = new HashMap<>();

      void setBit(final String key, final int n) {
          final StringBuilder s = this.map.get(key);
          final char c = s.charAt(n / 16);
          s.setCharAt(n / 16, (char) (c | 1 << n % 16));
      }

      int getBit(final String key, final int n) {
          final StringBuilder s = this.map.get(key);
          final int c = s.charAt(n / 16);
          return (c << n % 16 & 0x8000) != 0 ? 1 : 0;
      }

      CharSequence getValue(final String key) {
          return this.map.get(key);
      }

      public static void main(final String[] args) {
          final Test t = new Test();
          t.map.put("x", new StringBuilder("abc"));
          t.map.put("y", new StringBuilder("abc"));
          t.setBit("x", 3);
          t.setBit("y", 4);

          // many methods accept any CharSequence not just String
          final CharSequence xValue = t.getValue("x");
          final CharSequence yValue = t.getValue("y");
          System.out.println(String.join(",", xValue, yValue));
      }
}