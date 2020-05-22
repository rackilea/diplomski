public String addnumbers (int n, int digitsleft, String outstr)
{
    int d;
    int last_digit = n % 10;
    if (digitsleft == 1) {
        d = (last_digit+1) % 2 == 0 ? last_digit+1 : last_digit+2;
        for ( ; d <= 8; d += 2) {
            outstr = outstr + (10*n+d) + " ";
        }
    }
    else {
        for (d=last_digit+1; d < 8; ++d) {
            outstr = addnumbers(10*n+d, digitsleft-1, outstr);
        }
    }
    return outstr;
}
public String orderAndPrint(int decimal)
{
    // Assume decimal is at least 1
    String outstr = "2 4 6 8 "
    int d;

    decimal = Math.min(8, decimal);
    for (d = 1; d < 8; ++d) {
        outstr = addnumbers(d, decimal-1, outstr);
    }
    return outstr + "End";
}