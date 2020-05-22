int year  = bits(n, 0,  6),
    month = bits(n, 6,  4),
    day   = bits(n, 10, 5),
    hour  = bits(n, 15, 5),
    min   = bits(n, 20, 6),
    sec   = bits(n, 26, 6);