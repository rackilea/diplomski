// before
if (doors[x] == true)
    doors[x] = false;
else if (doors[x] == false)
    doors[x] = true;

// after
doors[x] = ! doors[x];

// skip double evaluation of index lookup
doors[x] ^= true;