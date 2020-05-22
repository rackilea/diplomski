public boolean check(int num)
{
    // This is actually unnecessary as check is called only for even numbers
    if ((num % 2) != 0)
        return false;
    int prev_digit = 10;
    while (num > 0) {
        int last_digit = num % 10;
        if (last_digit >= prev_digit)
            return false;
        prev_digit = last_digit;
        num = num / 10;
    }
    return true;
}

public String orderAndPrint(int decimal)
{
    String outstr = ""
    int last_num = Math.pow(10, decimal);
    int num = 2;
    for ( ; num < last_num; num += 2) {
        if (check(num))
            outstr = outstr + num + " ";
    }
    return outstr + "End";
}