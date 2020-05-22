package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RoundingHelper {

    public static String round(BigDecimal value, RoundingMode mode, String pattern) {
        DecimalFormat format = new DecimalFormat(pattern);
        format.setRoundingMode(mode);
        return format.format(value);
    }
}