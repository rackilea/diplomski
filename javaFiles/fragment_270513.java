static double getNicerNumber(double val)
{
    // get the first larger power of 10
    var nice = Math.pow(10, Math.ceiling(Math.log10(val)));

    // scale the power to a "nice enough" value
    if (val < 0.25 * nice)
        nice = 0.25 * nice;
    else if (val < 0.5 * nice)
        nice = 0.5 * nice;

    return nice;
}

// test program:
static void main(string[] args)
{
    double[] values = 
    {
        0.1, 0.2, 0.7,
        1, 2, 9,
        25, 58, 99,
        158, 267, 832
    };

    for (var val : values)
        System.out.printf("$%.2f --> $%.2f%n", val, getNicerNumber(val));
}