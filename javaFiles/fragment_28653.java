int H = number/100;//hundreds digit
    System.out.print(hundred[H]);

    int remainder = number % 100;//the tens and ones digits
    int I = remainder/10;//tens digit
    int remainder1 = remainder % 10;//ones digit

    if(remainder >= 11 && remainder <=19)
    System.out.print(teens[remainder1]);//remainder1 - 1 considering the array starts from 11
    else
    {
        System.out.print(tens[I]);
        System.out.print(ones[remainder1]);
    }