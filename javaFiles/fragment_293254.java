public static void main(int d, int m, int y)
{
   int n = (d + 5 * ((year - 1) % 4) + 4 * ((year - 1) % 100) + 6 * ((year - 1) % 400)) % 7;

   switch (m) {
        case 12: n += 30;
        case 11: n += 31;
        case 10: n += 30;
        case 9:  n += 31
        case 8:  n += 31;
        case 7:  n += 30
        case 6:  n += 31
        case 5:  n += 30
        case 4:  n += 31
        case 3:  n += 28;
                 if(returnLeap(y)) { n++; }
        case 2:  n += 31;
    }
    System.out.println(n % 7);
}