int sec   = bits(n, 0,  6),
    min   = bits(n, 6,  6),
    hour  = bits(n, 12, 5),
    day   = bits(n, 17, 5),
    month = bits(n, 22, 4),
    year  = bits(n, 26, 6);