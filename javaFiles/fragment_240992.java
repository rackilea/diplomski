private static boolean atLeast(double[] numbers, double thisNumber)
    for (double d : numbers)
        if (d >= thisNumber)
            return true;
    return false;
}