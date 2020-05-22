// constants
long nanosPerSecond = 1000_000_000L;
String pattern = "yyyy-MM-dd HH:mm:ss.n";

// assuming the bytes in the file are in little endian byte order
byte[] arr = Files.readAllBytes(path);

// transform to big endian (required by BigInteger)
ArrayUtils.reverse(arr);
// always positive
BigInteger number = new BigInteger(1, arr);

// get seconds since epoch and nano adjustment
long nanoAdjustment = number.mod(BigInteger.valueOf(nanosPerSecond))
  .longValueExact();
long epochSecond = number.divide(BigInteger.valueOf(nanosPerSecond))
  .longValueExact();

Instant instant = Instant.ofEpochSecond(epochSecond, nanoAdjustment);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern).withZone(ZoneId.systemDefault());
System.out.println(formatter.format(instant));