// Up right
if (y > x) { row = 8; column = 8-(y-x) } else { row = 8-(x-y); column = 8; }

// Down left
if (x > y) { row = 1; column = 1+(x-y) } else { row = 1+(y-x); column = 1; }

// Up left
if (9-x < y) { row = 8; column = x+y-8 } else { row = x+y-1; column = 1; }

// Down right
if (9-x > y) { row = 1; column = x+y-1 } else { row = x+y-8; column = 8; }