// use INSTANT_SECONDS, thus this code is not bound by Instant.MAX
Long inSec = context.getValue(INSTANT_SECONDS);
if (inSec >= -SECONDS_0000_TO_1970) {
    // current era
    long zeroSecs = inSec - SECONDS_PER_10000_YEARS + SECONDS_0000_TO_1970;
    long hi = Math.floorDiv(zeroSecs, SECONDS_PER_10000_YEARS) + 1;
    long lo = Math.floorMod(zeroSecs, SECONDS_PER_10000_YEARS);
    LocalDateTime ldt = LocalDateTime.ofEpochSecond(lo - SECONDS_0000_TO_1970, 0, ZoneOffset.UTC);
    if (hi > 0) {
         buf.append('+').append(hi);
    }
    buf.append(ldt);
}