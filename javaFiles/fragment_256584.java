i) TAI = (29 * 365 + 7) days * 86400 + 22 leap seconds + 10s (offset at 1972) = 915148832
 ii) UTC = TAI - 10 = 915148822 (fixed relation between UTC and TAI on epoch-second-level)
iii) POSIX = UTC - 22 leap seconds = 915148800

=> (ymdhms-form);
  i) TAI (915148800 + 32) = 1999-01-01T00:00:32 (based on TAI-"day" = 86400 SI-secs)
 ii) UTC = 1999-01-01T00:00:00 (stripped off former 22 leap secs in conversion to ymdhms)
iii) POSIX = 1999-01-01T00:00:00 (fixed relation between UTC and POSIX with exception of leapsecs)