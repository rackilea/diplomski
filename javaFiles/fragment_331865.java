// Convert an integer (from 0 to 2176782335) into a 6-digit string in base 36.
// The result is obfuscated by using modular arithmetic, i.e. multiply by the
// (arbitrarily selected) prime number 1708159939 modulo 36^6 (2176782336)

public static String obfuscate(Long n) {
  Long x;
  x = (n * 1708159939L) % 2176782336L;
  return String.format("%6s",Long.toString(x, 36).toUpperCase()).replace(' ','0');
}


// Inverse of the above function. Converts a 6-character base 36 string into
// an integer value. The number 1553655019 is the modular inverse of 1708159939
// (i.e., 1708159939 * 1553655019 = 1 (mod 36^6)

public static Long deobfuscate(String s) {
  return (Long.valueOf(s, 36) * 1553655019L) % 2176782336L;
}