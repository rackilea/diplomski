// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Season.java


final class Season extends Enum
{

    public static Season[] values()
    {
        return (Season[])$VALUES.clone();
    }

    public static Season valueOf(String s)
    {
        return (Season)Enum.valueOf(Season, s);
    }

    private Season(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static final Season WINTER;
    public static final Season SUMMER;
    private int value;
    private static final Season $VALUES[];

    static 
    {
        WINTER = new Season("WINTER", 0, 10);
        SUMMER = new Season("SUMMER", 1, 20);
        $VALUES = (new Season[] {
            WINTER, SUMMER
        });
    }
}