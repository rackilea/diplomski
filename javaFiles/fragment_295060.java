void makeBacon (int flags) {
     if ((flags & FLAG_CRISPY) != 0) // bitwise AND to check for flag
         ... flag is set
     if ((flags & FLAG_SMOKED) != 0) // bitwise AND to check for flag
         ... flag is set
     if ((flags & FLAG_ENDLESS) != 0) // bitwise AND to check for flag
         ... flag is set
 }