static int offset;
static long firstCall;

public static void main(String[] args)
{
    System.out.println(currentTime());
    System.out.println(currentTime());
    System.out.println(currentTime());
}

public static String currentTime()
{
    if (offset == 0)
    {
        firstCall = System.currentTimeMillis();
    }

    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(firstCall + (offset * 1000 * 60));
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    offset++;
    return sdf.format(cal.getTime());
}