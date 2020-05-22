if (d < 0) throw new IllegalArgumentException("Argument was negative");
if (d > UPPER_LIMIT) throw new IllegalArgumentException("Argument too large");
return d < THRESHOLD_0? 0
     : d < THRESHOLD_1? 1
     : d < THRESHOLD_2? 2
     : d < THRESHOLD_3? 3
     : 4;