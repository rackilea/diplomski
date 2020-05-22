long colour = 0L;
long full   = 0L;

// set position 17 to white
colour &= ~(1L << 17);    // clear the bit (white)
full   |=  (1L << 17);    // set it to occupied

// set position 42 to black
colour |=  (1L << 42);    // set the bit (black)
full   |=  (1L << 42);    // set it to occupied

// is position 25 occupied?
if ((full & (1L<<25)) != 0) {
    // yes, but what colour?
    if ((colour & (1L<<25)) != 0)
        // black
    else
        // white
}

// is the grid full?
if (full == -1L)
     // yes it is!
else
     // no it isn't