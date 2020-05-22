short a = 4;     // representable constant
short b = 5;     // representable constant
short c = 5 + 4; // representable constant
short d = a;     // identity conversion
short e = a + b; // DOES NOT COMPILE! Result of addition is int

short z  = 32767; // representable constant
short z_ = 32768; // DOES NOT COMPILE! Unrepresentable constant