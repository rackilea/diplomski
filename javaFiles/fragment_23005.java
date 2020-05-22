import java.util.Scanner;

class Easter
{
    public static void main(String[] args)
    {
        System.out.print("Please enter a year to calculate Easter Sunday\n>");
        Scanner s = new Scanner(System.in);
        int inputted = getResult(s);
        while(inputted <= 0)
        {
            System.out.print("Expected a positive year. Please try again:\n>");
            inputted = getResult(s);
        }
        System.out.println(getEasterSundayDate(inputted));
    }

    private static int getResult(Scanner s)
    {
        while(!s.hasNextInt())
        {
            System.out.print("Expected a valid year. Please try again:\n>");
            s.nextLine();
        }
        return s.nextInt();
    }

    public static String getEasterSundayDate(int year)
    {
        int a = year % 19,
            b = year / 100,
            c = year % 100,
            d = b / 4,
            e = b % 4,
            g = (8 * b + 13) / 25,
            h = (19 * a + b - d - g + 15) % 30,
            j = c / 4,
            k = c % 4,
            m = (a + 11 * h) / 319,
            r = (2 * e + 2 * j - k - h + m + 32) % 7,
            n = (h - m + r + 90) / 25,
            p = (h - m + r + n + 19) % 32;

        String result;
        switch(n)
        {
            case 1:
                result = "January ";
                break;
            case 2:
                result = "February ";
                break;
            case 3:
                result = "March ";
                break;
            case 4:
                result = "April ";
                break;
            case 5:
                result = "May ";
                break;
            case 6:
                result = "June ";
                break;
            case 7:
                result = "July ";
                break;
            case 8:
                result = "August ";
                break;
            case 9:
                result = "September ";
                break;
            case 10:
                result = "October ";
                break;
            case 11:
                result = "November ";
                break;
            case 12:
                result = "December ";
                break;
            default:
                result = "error";
        }

        return result + p;
    }
}