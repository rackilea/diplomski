public static long MAX_SAFE_VALUE = 
        sun.misc.DoubleConsts.SIGNIF_BIT_MASK * 2 + 1;

// alternatively
public static long MAX_SAFE_VALUE = 
        Math.pow(2, sun.misc.DoubleConsts.SIGNIFICAND_WIDTH) - 1;