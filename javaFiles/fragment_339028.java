public static void main(String[] args)
{
    Calendar c1 = Calendar.getInstance();
    System.out.printf("Initial: %s\n",c1.getTime().toString());
    c1.set(Calendar.AM_PM, Calendar.AM);
    System.out.printf("Set(AM): %s\n",c1.getTime().toString());
    c1.set(Calendar.HOUR, 12);
    System.out.printf("Set(12): %s\n\n",c1.getTime().toString());

    Calendar c2 = Calendar.getInstance();
    System.out.printf("Initial: %s\n",c2.getTime().toString());
    c2.set(Calendar.AM_PM, Calendar.PM);
    System.out.printf("Set(PM): %s\n",c2.getTime().toString());
    c2.set(Calendar.HOUR, 12);
    System.out.printf("Set(12): %s\n\n",c2.getTime().toString());
}